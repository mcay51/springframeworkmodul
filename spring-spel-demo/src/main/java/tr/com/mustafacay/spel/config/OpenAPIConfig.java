package tr.com.mustafacay.spel.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI spelDemoOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Expression Language (SpEL) Demo API")
                        .description("SpEL ifadelerini değerlendirmek için REST API")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Mustafa Çay")
                                .email("contact@mustafacay.com")
                                .url("https://github.com/username"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));
    }
} 