package tr.com.mustafacay.instrumentation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Metod performansını izleyen aspect
 * Load-time weaving ile çalışma zamanında uygulanır
 */
@Aspect
@Component
public class PerformanceMonitoringAspect {
    
    private static final Logger logger = LoggerFactory.getLogger(PerformanceMonitoringAspect.class);
    
    @Around("@annotation(tr.com.mustafacay.instrumentation.annotation.MonitorPerformance)")
    public Object monitorPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        
        try {
            return joinPoint.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            logger.info("Method {} took {} ms to execute", 
                joinPoint.getSignature().getName(), 
                (endTime - startTime));
        }
    }
} 