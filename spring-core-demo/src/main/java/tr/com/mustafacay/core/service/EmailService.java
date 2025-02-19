package tr.com.mustafacay.core.service;

import org.springframework.stereotype.Service;

/**
 * Email mesaj gönderme işlemlerini yöneten servis sınıfı.
 * MessageService arayüzünü implemente eder.
 */
@Service("emailService")
public class EmailService implements MessageService {
    
    /**
     * Email mesaj içeriğini döndürür.
     * @return Email mesaj içeriği
     */
    @Override
    public String getMessage() {
        // Email gönderme işlemi simülasyonu
        return "Email message sent!";
    }
} 