package tr.com.mustafacay.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Metot performansını ölçen Aspect sınıfı.
 * UserService sınıfındaki metotların çalışma süresini ölçer.
 */
@Aspect
@Component
public class PerformanceAspect {
    
    /**
     * UserService sınıfındaki tüm metotların çalışma süresini ölçer
     * @param joinPoint metot çağrısı hakkında bilgi içeren nesne
     * @return metottan dönen sonuç
     * @throws Throwable metot çalışması sırasında oluşabilecek hatalar
     */
    @Around("execution(* tr.com.mustafacay.aop.service.UserService.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // Metot başlangıç zamanı
        long start = System.currentTimeMillis();
        
        // Asıl metodu çalıştır
        Object result = joinPoint.proceed();
        
        // Metot bitiş zamanı ve süre hesaplama
        long end = System.currentTimeMillis();
        System.out.println(joinPoint.getSignature().getName() + " metodu " + (end - start) + "ms sürdü");
        
        return result;
    }
} 