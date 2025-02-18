package tr.com.mustafacay.context.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {
    
    @Bean
    @Profile("dev")
    public DataSource devDataSource() {
        return new DevDataSource();
    }
    
    @Bean
    @Profile("prod")
    public DataSource prodDataSource() {
        return new ProdDataSource();
    }
} 