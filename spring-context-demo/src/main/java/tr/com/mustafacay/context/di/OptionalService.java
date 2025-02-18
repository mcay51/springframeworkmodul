package tr.com.mustafacay.context.di;

import org.springframework.stereotype.Service;

@Service
public class OptionalService {
    
    public String doOptionalWork() {
        return "OptionalService is doing optional work";
    }
} 