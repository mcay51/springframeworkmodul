package tr.com.mustafacay.core;

import tr.com.mustafacay.core.controller.MessageController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCoreDemoApplication {
    
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringCoreDemoApplication.class, args);
        MessageController controller = context.getBean(MessageController.class);
        System.out.println(controller.showMessage());
    }
} 