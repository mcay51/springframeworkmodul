package tr.com.mustafacay.context.env;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentDemo implements EnvironmentAware {
    
    private Environment environment;
    
    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
    
    public String getActiveProfiles() {
        return String.join(", ", environment.getActiveProfiles());
    }
    
    public String getProperty(String key) {
        return environment.getProperty(key);
    }
} 