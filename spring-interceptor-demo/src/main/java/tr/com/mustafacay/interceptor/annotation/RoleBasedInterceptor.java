package tr.com.mustafacay.interceptor.annotation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class RoleBasedInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
            throws Exception {
        
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        RequiresRole methodAnnotation = handlerMethod.getMethodAnnotation(RequiresRole.class);
        RequiresRole classAnnotation = handlerMethod.getBeanType().getAnnotation(RequiresRole.class);

        if (methodAnnotation == null && classAnnotation == null) {
            return true;
        }

        RequiresRole annotation = methodAnnotation != null ? methodAnnotation : classAnnotation;
        List<String> requiredRoles = Arrays.asList(annotation.value());
        
        // Kullanıcının rolünü al (gerçek uygulamada security context'ten alınır)
        String userRole = getUserRole(request);
        
        if (userRole == null) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }

        boolean hasAccess = annotation.anyRole() 
            ? requiredRoles.contains(userRole)
            : requiredRoles.stream().allMatch(role -> role.equals(userRole));

        if (!hasAccess) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            log.warn("Access denied for user with role {} to endpoint {}", userRole, request.getRequestURI());
            return false;
        }

        return true;
    }

    private String getUserRole(HttpServletRequest request) {
        // Gerçek uygulamada security context'ten alınır
        return request.getHeader("X-User-Role");
    }
} 