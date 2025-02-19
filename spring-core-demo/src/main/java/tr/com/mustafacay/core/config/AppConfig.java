package tr.com.mustafacay.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring uygulama konfigürasyon sınıfı.
 * Component tarama işlemini yönetir.
 */
@Configuration
@ComponentScan(basePackages = "tr.com.mustafacay.core")
public class AppConfig {
    // Uygulama genel konfigürasyonları burada yapılabilir
} 