package tr.com.mustafacay.context.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Value("${server.port}")
    private String serverPort;

    @Bean
    public OpenAPI springContextOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Spring Context Demo API")
                .description("""
                    Spring Context modülünün özelliklerini gösteren API.
                    
                    Test edilebilen özellikler:
                    * Bean Scopes (Singleton, Prototype, Request)
                    * Internationalization (i18n)
                    * Event Handling
                    * Environment & Profiles
                    * Resource Management
                    * Bean Validation
                    * Dependency Injection
                    * Bean Lifecycle
                    """)
                .version("v1.0.0")
                .license(new License()
                    .name("MIT License")
                    .url("https://opensource.org/licenses/MIT")))
            .servers(List.of(
                new Server()
                    .url("http://localhost:" + serverPort)
                    .description("Local Development Server")
            ));
    }
} 