package tr.com.mustafacay.core.controller;

import tr.com.mustafacay.core.service.MessageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageController {
    
    private final MessageService messageService;
    
    public MessageController(@Qualifier("emailService") MessageService messageService) {
        this.messageService = messageService;
    }
    
    public String showMessage() {
        return messageService.getMessage();
    }
} 