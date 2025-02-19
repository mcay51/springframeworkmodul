package tr.com.mustafacay.spel.exception;

/**
 * SpEL ifadesi değerlendirme hatalarını temsil eden özel exception sınıfı.
 *
 * @author Mustafa Çay
 * @version 1.0
 * @since 1.0
 */
public class SpELEvaluationException extends RuntimeException {
    
    private final String expression;
    private final String errorCode;
    
    public SpELEvaluationException(String message, String expression) {
        super(message);
        this.expression = expression;
        this.errorCode = "SPEL_EVALUATION_ERROR";
    }
    
    public SpELEvaluationException(String message, String expression, Throwable cause) {
        super(message, cause);
        this.expression = expression;
        this.errorCode = "SPEL_EVALUATION_ERROR";
    }
    
    public SpELEvaluationException(String message, String expression, String errorCode) {
        super(message);
        this.expression = expression;
        this.errorCode = errorCode;
    }
    
    public String getExpression() {
        return expression;
    }
    
    public String getErrorCode() {
        return errorCode;
    }
} 