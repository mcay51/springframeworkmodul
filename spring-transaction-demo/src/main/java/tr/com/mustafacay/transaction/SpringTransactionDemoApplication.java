package tr.com.mustafacay.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring Transaction Demo uygulaması
 * Declarative ve Programmatic transaction yönetimini göstermek için örnek uygulama
 */
@SpringBootApplication
@EnableTransactionManagement
public class SpringTransactionDemoApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringTransactionDemoApplication.class, args);
    }
} 