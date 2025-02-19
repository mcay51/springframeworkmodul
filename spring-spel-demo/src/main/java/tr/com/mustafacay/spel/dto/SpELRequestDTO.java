package tr.com.mustafacay.spel.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class SpELRequestDTO {
    
    /**
     * Değerlendirilecek SpEL ifadesi.
     * Boş olamaz.
     */
    @NotBlank(message = "SpEL ifadesi boş olamaz")
    private String expression;
    
    /**
     * İfadenin değerlendirileceği bağlam nesnesi.
     * Opsiyonel. Null olabilir.
     */
    private Object context;
    
    /**
     * Beklenen sonuç tipi.
     * Örnek: "string", "boolean", "number" vb.
     * Opsiyonel. Null olabilir.
     */
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