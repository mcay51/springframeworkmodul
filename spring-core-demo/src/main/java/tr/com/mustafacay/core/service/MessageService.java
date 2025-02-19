package tr.com.mustafacay.core.service;

/**
 * Mesaj servisi için temel arayüz.
 * Farklı mesaj gönderme yöntemleri için implementasyon sağlar.
 */
public interface MessageService {
    /**
     * Mesaj içeriğini döndürür.
     * @return Gönderilecek mesajın içeriği
     */
    String getMessage();
} 