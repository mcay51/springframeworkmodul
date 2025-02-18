package tr.com.mustafacay.context.scope;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

@Component
@Scope("singleton")
public class SingletonBean {
    private String message = "Ben bir singleton bean'im!";
    
    public String getMessage() {
        return message;
    }
} 