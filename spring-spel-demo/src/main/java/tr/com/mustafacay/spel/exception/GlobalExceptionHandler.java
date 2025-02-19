package tr.com.mustafacay.spel.exception;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.EvaluationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Uygulama genelinde exception'ları yakalayıp uygun response'ları üreten handler.
 *
 * @author Mustafa Çay
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SpELEvaluationException.class)
    public ResponseEntity<ErrorResponse> handleSpELEvaluationException(SpELEvaluationException ex) {
        log.error("SpEL değerlendirme hatası: {}", ex.getMessage(), ex);
        
        ErrorResponse error = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("SpEL Değerlendirme Hatası")
                .message(ex.getMessage())
                .expression(ex.getExpression())
                .errorCode(ex.getErrorCode())
                .build();
                
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(EvaluationException.class)
    public ResponseEntity<ErrorResponse> handleEvaluationException(EvaluationException ex) {
        log.error("İfade değerlendirme hatası: {}", ex.getMessage(), ex);
        
        ErrorResponse error = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("İfade Değerlendirme Hatası")
                .message(ex.getMessage())
                .build();
                
        return ResponseEntity.badRequest().body(error);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(errors);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        log.error("Beklenmeyen hata: {}", ex.getMessage(), ex);
        
        ErrorResponse error = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error("Sistem Hatası")
                .message("İşlem sırasında beklenmeyen bir hata oluştu")
                .build();
                
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
    
    @Data
    @Builder
    private static class ErrorResponse {
        private LocalDateTime timestamp;
        private int status;
        private String error;
        private String message;
        private String expression;
        private String errorCode;
    }
} 