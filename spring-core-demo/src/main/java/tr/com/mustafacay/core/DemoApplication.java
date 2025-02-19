package tr.com.mustafacay.core;

import tr.com.mustafacay.core.config.AppConfig;
import tr.com.mustafacay.core.controller.MessageController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        MessageController controller = context.getBean(MessageController.class);
        controller.sendMessage();
        
        // XML Bean Factory kullanımı
        XmlBeanFactoryDemo xmlDemo = new XmlBeanFactoryDemo();
        xmlDemo.runDemo();
    }
} 