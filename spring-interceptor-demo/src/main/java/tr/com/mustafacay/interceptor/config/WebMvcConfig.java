package tr.com.mustafacay.interceptor.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tr.com.mustafacay.interceptor.LoggingInterceptor;
import tr.com.mustafacay.interceptor.auth.AuthenticationInterceptor;
import tr.com.mustafacay.interceptor.performance.PerformanceInterceptor;
import tr.com.mustafacay.interceptor.logging.RequestResponseLoggingInterceptor;
import tr.com.mustafacay.interceptor.annotation.RoleBasedInterceptor;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final AuthenticationInterceptor authenticationInterceptor;
    private final PerformanceInterceptor performanceInterceptor;
    private final RequestResponseLoggingInterceptor requestResponseLoggingInterceptor;
    private final RoleBasedInterceptor roleBasedInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Request/Response logging interceptor
        registry.addInterceptor(requestResponseLoggingInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/error", "/favicon.ico");

        // Performance interceptor
        registry.addInterceptor(performanceInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/error", "/favicon.ico");

        // Basic logging interceptor
        registry.addInterceptor(new LoggingInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/error", "/favicon.ico");

        // Role based interceptor
        registry.addInterceptor(roleBasedInterceptor)
                .addPathPatterns("/api/**");

        // Authentication interceptor
        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/public/**", "/api/auth/**", "/api/performance/**");
    }
} 