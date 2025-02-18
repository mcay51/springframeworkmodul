package tr.com.mustafacay.context.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class AdvancedLifecycleBean implements InitializingBean, DisposableBean {
    
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean: afterPropertiesSet called");
    }
    
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean: destroy called");
    }
    
    public void customInit() {
        System.out.println("Custom init method called");
    }
    
    public void customDestroy() {
        System.out.println("Custom destroy method called");
    }
} 