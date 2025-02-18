package tr.com.mustafacay.transaction.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

/**
 * Para transferi için request DTO
 */
@Schema(description = "Para transferi isteği")
public class TransferRequest {
    
    @Schema(description = "Gönderen hesap numarası")
    @NotBlank(message = "Gönderen hesap numarası zorunludur")
    private String fromAccount;
    
    @Schema(description = "Alıcı hesap numarası")
    @NotBlank(message = "Alıcı hesap numarası zorunludur")
    private String toAccount;
    
    @Schema(description = "Transfer miktarı")
    @NotNull(message = "Transfer miktarı zorunludur")
    @Positive(message = "Transfer miktarı pozitif olmalıdır")
    private BigDecimal amount;
    
    // Getters and Setters
    public String getFromAccount() {
        return fromAccount;
    }
    
    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }
    
    public String getToAccount() {
        return toAccount;
    }
    
    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
} 