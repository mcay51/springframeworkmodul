package tr.com.mustafacay.transaction.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Hata yanıtı")
public class ErrorResponse {
    
    @Schema(description = "HTTP durum kodu")
    private int status;
    
    @Schema(description = "Hata mesajı")
    private String message;
    
    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
    
    // Getters
    public int getStatus() {
        return status;
    }
    
    public String getMessage() {
        return message;
    }
} 