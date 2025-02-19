package tr.com.mustafacay.spel.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * SpEL ifadesi değerlendirme isteği için DTO sınıfı.
 * Bu sınıf, client'tan gelen SpEL ifadesi ve ilgili parametreleri taşır.
 *
 * @author Mustafa Çay
 * @version 1.0
 * @since 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "SpEL ifadesi değerlendirme isteği")
public class SpELRequestDTO {
    
    /**
     * Değerlendirilecek SpEL ifadesi.
     * Boş olamaz.
     */
    @Schema(description = "Değerlendirilecek SpEL ifadesi", example = "2 + 2")
    @NotBlank(message = "SpEL ifadesi boş olamaz")
    private String expression;
    
    /**
     * İfadenin değerlendirileceği bağlam nesnesi.
     * Opsiyonel. Null olabilir.
     */
    @Schema(description = "İfadenin değerlendirileceği bağlam nesnesi")
    private Object context;
    
    /**
     * Beklenen sonuç tipi.
     * Örnek: "string", "boolean", "number" vb.
     * Opsiyonel. Null olabilir.
     */
    @Schema(description = "Beklenen sonuç tipi", example = "string")
    private String targetType;
    
    /**
     * İfadenin değerlendirileceği root nesne.
     * Opsiyonel. Null olabilir.
     */
    private Object rootObject;
    
    /**
     * İfadenin değerlendirileceği değişkenler.
     * Opsiyonel. Null olabilir.
     */
    private Object[] variables;
} 