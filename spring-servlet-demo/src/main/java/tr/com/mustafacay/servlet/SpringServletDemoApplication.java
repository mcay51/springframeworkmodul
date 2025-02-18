package tr.com.mustafacay.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Spring Servlet Demo uygulaması
 * Servlet, Filter ve Listener örneklerini göstermek için
 */
@SpringBootApplication
@ServletComponentScan // Servlet bileşenlerini taramak için
public class SpringServletDemoApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringServletDemoApplication.class, args);
    }
} 