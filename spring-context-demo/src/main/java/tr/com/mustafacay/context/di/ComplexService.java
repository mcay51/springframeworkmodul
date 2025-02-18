package tr.com.mustafacay.context.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplexService {
    
    private final SimpleService simpleService; // Constructor injection
    
    @Autowired
    private OptionalService optionalService; // Field injection
    
    private AnotherService anotherService; // Setter injection
    
    private ConfigService configService; // Method injection
    
    public ComplexService(SimpleService simpleService) {
        this.simpleService = simpleService;
    }
    
    @Autowired
    public void setAnotherService(AnotherService anotherService) {
        this.anotherService = anotherService;
    }
    
    @Autowired
    public void init(ConfigService configService) {
        this.configService = configService;
    }
    
    public String executeAllServices() {
        StringBuilder result = new StringBuilder();
        result.append("Complex service results:\n");
        result.append("1. ").append(simpleService.doSomething()).append("\n");
        result.append("2. ").append(optionalService.doOptionalWork()).append("\n");
        result.append("3. ").append(anotherService.doAnotherThing()).append("\n");
        result.append("4. ").append(configService.getConfig());
        return result.toString();
    }
} 