package tr.com.mustafacay.core;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import tr.com.mustafacay.core.service.MessageService;

public class XmlBeanFactoryDemo {
    public void runDemo() {
        XmlBeanFactory factory = new XmlBeanFactory(
            new ClassPathResource("beans.xml")
        );
        
        MessageService service = (MessageService) factory.getBean("xmlMessageService");
        System.out.println("XML Bean Factory Message: " + service.getMessage());
    }
} 