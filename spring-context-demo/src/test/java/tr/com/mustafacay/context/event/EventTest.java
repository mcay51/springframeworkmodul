package tr.com.mustafacay.context.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;

@SpringBootTest
class EventTest {
    
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    
    @Test
    void testEventPublishing() {
        eventPublisher.publishEvent(new CustomEvent(this, "Test event"));
    }
} 