package tr.com.mustafacay.instrumentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.EnableLoadTimeWeaving.AspectJWeaving;

/**
 * Spring Instrumentation Demo uygulaması
 * Load-time weaving özelliğini göstermek için örnek uygulama
 */
@SpringBootApplication
@EnableLoadTimeWeaving(aspectjWeaving = AspectJWeaving.ENABLED)
public class SpringInstrumentationDemoApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringInstrumentationDemoApplication.class, args);
    }
} 