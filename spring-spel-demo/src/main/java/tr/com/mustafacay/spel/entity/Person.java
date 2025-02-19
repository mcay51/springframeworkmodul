package tr.com.mustafacay.spel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

/**
 * Kişi bilgilerini temsil eden entity sınıfı.
 *
 * @author Mustafa Çay
 * @version 1.0
 * @since 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private Address address;
    private String email;
    private String phone;
    
    /**
     * Kişinin yaşını hesaplar.
     *
     * @return hesaplanan yaş
     */
    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
    
    /**
     * Kişinin reşit olup olmadığını kontrol eder.
     *
     * @return 18 yaşından büyükse true, değilse false
     */
    public boolean isAdult() {
        return getAge() >= 18;
    }
    
    /**
     * Kişinin tam adını döndürür.
     *
     * @return ad soyad formatında tam isim
     */
    public String getFullName() {
        return String.format("%s %s", name, surname);
    }
    
    /**
     * Kişinin iletişim bilgilerini döndürür.
     *
     * @return email ve telefon bilgilerini içeren string
     */
    public String getContactInfo() {
        return String.format("Email: %s, Phone: %s", email, phone);
    }
} 