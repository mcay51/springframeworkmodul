package tr.com.mustafacay.context.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class LifecycleBean {
    
    public LifecycleBean() {
        System.out.println("Constructor çağrıldı");
    }
    
    @PostConstruct
    public void init() {
        System.out.println("Bean initialize edildi");
    }
    
    @PreDestroy
    public void destroy() {
        System.out.println("Bean destroy ediliyor");
    }
} 