package tr.com.mustafacay.context.di;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {
    
    public String doSomething() {
        return "SimpleService is doing something";
    }
} 