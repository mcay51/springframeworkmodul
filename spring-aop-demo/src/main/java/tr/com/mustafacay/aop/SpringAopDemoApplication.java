package tr.com.mustafacay.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import tr.com.mustafacay.aop.service.UserService;

/**
 * Spring AOP Demo uygulamasının başlangıç noktası.
 * Bu uygulama, Spring AOP'nin temel özelliklerini göstermektedir.
 */
@SpringBootApplication
public class SpringAopDemoApplication {
    
    public static void main(String[] args) {
        // Spring context'i başlat
        ApplicationContext context = SpringApplication.run(SpringAopDemoApplication.class, args);
        
        // UserService bean'ini al ve test et
        UserService userService = context.getBean(UserService.class);
        userService.createUser("mustafa");
        userService.deleteUser("mustafa");
    }
} 