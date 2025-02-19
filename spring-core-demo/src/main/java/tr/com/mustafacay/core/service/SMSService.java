package tr.com.mustafacay.core.service;

import org.springframework.stereotype.Service;

/**
 * SMS mesaj gönderme işlemlerini yöneten servis sınıfı.
 * MessageService arayüzünü implemente eder.
 */
@Service("smsService")
public class SmsService implements MessageService {
    
    /**
     * SMS mesaj içeriğini döndürür.
     * @return SMS mesaj içeriği
     */
    @Override
    public String getMessage() {
        // SMS gönderme işlemi simülasyonu
        return "SMS message sent!";
    }
} 