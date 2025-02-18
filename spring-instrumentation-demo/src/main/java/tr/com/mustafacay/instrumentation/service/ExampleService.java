package tr.com.mustafacay.instrumentation.service;

import org.springframework.stereotype.Service;
import tr.com.mustafacay.instrumentation.annotation.MonitorPerformance;

/**
 * Performans izleme örneği için örnek servis
 */
@Service
public class ExampleService {
    
    @MonitorPerformance
    public void slowOperation() throws InterruptedException {
        // Yavaş işlem simülasyonu
        Thread.sleep(1000);
    }
} 