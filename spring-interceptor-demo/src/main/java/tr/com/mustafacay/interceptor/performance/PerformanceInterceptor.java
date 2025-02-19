package tr.com.mustafacay.interceptor.performance;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Component
public class PerformanceInterceptor implements HandlerInterceptor {
    
    private final Map<String, PerformanceMetrics> metricsMap = new ConcurrentHashMap<>();
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        request.setAttribute("startTime", System.nanoTime());
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, 
                          Object handler, ModelAndView modelAndView) {
        // Post handle işlemleri gerekirse
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
                               Object handler, Exception ex) {
        long startTime = (long) request.getAttribute("startTime");
        long duration = System.nanoTime() - startTime;
        
        String path = request.getRequestURI();
        PerformanceMetrics metrics = metricsMap.computeIfAbsent(path, k -> new PerformanceMetrics());
        
        metrics.addRequest(duration);
        
        log.info("Path: {}, Duration: {} ms, Avg: {} ms, Count: {}", 
                path, 
                duration / 1_000_000.0, 
                metrics.getAverageTime() / 1_000_000.0,
                metrics.getRequestCount());
    }
} 