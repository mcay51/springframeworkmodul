package tr.com.mustafacay.spel.dto;

import lombok.Data;

/**
 * SpEL değerlendirme sonuçları için DTO sınıfı.
 */
@Data
public class SpELResponseDTO {
    private String expression;
    private Object result;
    private String resultType;
    private boolean successful;
    private String errorMessage;
} 