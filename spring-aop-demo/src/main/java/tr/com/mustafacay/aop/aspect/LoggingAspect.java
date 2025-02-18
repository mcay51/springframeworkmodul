package tr.com.mustafacay.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Loglama işlemlerini gerçekleştiren Aspect sınıfı.
 * UserService sınıfındaki metotların öncesi ve sonrasında loglama yapar.
 */
@Aspect
@Component
public class LoggingAspect {
    
    /**
     * UserService sınıfındaki tüm metotlar çağrılmadan önce çalışır
     * @param joinPoint metot çağrısı hakkında bilgi içeren nesne
     */
    @Before("execution(* tr.com.mustafacay.aop.service.UserService.*(..))")
    public void beforeMethodExecution(JoinPoint joinPoint) {
        System.out.println("Metod başlamadan önce loglama: " + joinPoint.getSignature().getName());
    }
    
    /**
     * UserService sınıfındaki tüm metotlar tamamlandıktan sonra çalışır
     * @param joinPoint metot çağrısı hakkında bilgi içeren nesne
     */
    @After("execution(* tr.com.mustafacay.aop.service.UserService.*(..))")
    public void afterMethodExecution(JoinPoint joinPoint) {
        System.out.println("Metod bittikten sonra loglama: " + joinPoint.getSignature().getName());
    }
} 