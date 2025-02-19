package tr.com.mustafacay.spel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Adres bilgilerini temsil eden entity sınıfı.
 *
 * @author Mustafa Çay
 * @version 1.0
 * @since 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String city;
    private String country;
    private String postalCode;
    
    /**
     * Adresin tam formatını döndürür.
     *
     * @return street, city, country, postalCode formatında tam adres
     */
    public String getFullAddress() {
        return String.format("%s, %s, %s, %s", street, city, country, postalCode);
    }
    
    /**
     * Adresin kısa formatını döndürür.
     *
     * @return city, country formatında kısa adres
     */
    public String getShortAddress() {
        return String.format("%s, %s", city, country);
    }
} 