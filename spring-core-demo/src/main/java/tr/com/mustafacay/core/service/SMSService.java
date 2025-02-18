package tr.com.mustafacay.core.service;

import org.springframework.stereotype.Service;

@Service
public class SMSService implements MessageService {
    
    @Override
    public String getMessage() {
        return "SMS servisi mesajı";
    }
} 