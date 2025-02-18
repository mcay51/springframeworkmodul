package tr.com.mustafacay.context.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener {
    
    @EventListener
    public void handleCustomEvent(CustomEvent event) {
        System.out.println("Event alındı: " + event.getMessage());
    }
} 