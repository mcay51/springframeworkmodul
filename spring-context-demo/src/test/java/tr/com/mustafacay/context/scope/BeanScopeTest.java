package tr.com.mustafacay.context.scope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeanScopeTest {
    
    @Autowired
    private ApplicationContext context;
    
    @Test
    void testSingletonScope() {
        SingletonBean bean1 = context.getBean(SingletonBean.class);
        SingletonBean bean2 = context.getBean(SingletonBean.class);
        
        assertSame(bean1, bean2, "Singleton beans should be the same instance");
    }
    
    @Test
    void testPrototypeScope() {
        PrototypeBean bean1 = context.getBean(PrototypeBean.class);
        PrototypeBean bean2 = context.getBean(PrototypeBean.class);
        
        assertNotSame(bean1, bean2, "Prototype beans should be different instances");
    }
} 