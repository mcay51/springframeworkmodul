package tr.com.mustafacay.context.di;

import org.springframework.stereotype.Service;

@Service
public class ConfigService {
    
    public String getConfig() {
        return "ConfigService is providing configuration";
    }
} 