package tr.com.mustafacay.core.controller;

import tr.com.mustafacay.core.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Mesaj gönderme işlemlerini yöneten controller sınıfı.
 * Dependency Injection ile bağımlılıkları yönetir.
 */
@Controller
public class MessageController {

    private final MessageService messageService;

    /**
     * Constructor injection ile MessageService bağımlılığını enjekte eder.
     * @param messageService Kullanılacak mesaj servisi implementasyonu
     */
    @Autowired
    public MessageController(@Qualifier("emailService") MessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * Mesaj gönderme işlemini gerçekleştirir.
     */
    public void sendMessage() {
        // Mesajı konsola yazdır
        System.out.println(messageService.getMessage());
    }
} 