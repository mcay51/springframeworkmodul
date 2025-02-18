package tr.com.mustafacay.context.scope;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

@Component
@Scope("prototype")
public class PrototypeBean {
    private String message = "Ben bir prototype bean'im!";
    
    public String getMessage() {
        return message;
    }
} 