package tr.com.mustafacay.servlet.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger/OpenAPI konfigürasyonu
 */
@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI springServletOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Spring Servlet Demo API")
                .description("Spring Servlet modülü örnek uygulaması")
                .version("v1.0.0")
                .license(new License()
                    .name("Apache 2.0")
                    .url("http://springdoc.org")));
    }
} 