package tr.com.mustafacay.core.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService implements MessageService {
    
    @Override
    public String getMessage() {
        return "Email servisi mesajı";
    }
} 