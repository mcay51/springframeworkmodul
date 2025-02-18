package tr.com.mustafacay.web;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Web MVC Demo uygulamasının başlangıç noktası.
 * REST API örneklerini içerir.
 */
@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "Spring Web MVC Demo API",
        version = "1.0",
        description = "Spring Web MVC özelliklerini gösteren örnek REST API"
    )
)
public class SpringWebDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringWebDemoApplication.class, args);
    }
} 