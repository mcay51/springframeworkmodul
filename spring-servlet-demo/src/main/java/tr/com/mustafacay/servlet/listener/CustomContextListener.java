package tr.com.mustafacay.servlet.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ServletContext olaylarını dinleyen Listener örneği
 */
@WebListener
public class CustomContextListener implements ServletContextListener {
    
    private static final Logger logger = LoggerFactory.getLogger(CustomContextListener.class);
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("ServletContext initialized");
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("ServletContext destroyed");
    }
} 