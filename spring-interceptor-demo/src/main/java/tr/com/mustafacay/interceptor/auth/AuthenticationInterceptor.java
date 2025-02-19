package tr.com.mustafacay.interceptor.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthenticationInterceptor implements HandlerInterceptor {

    private static final String AUTH_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String authHeader = request.getHeader(AUTH_HEADER);
        
        if (isPublicEndpoint(request)) {
            return true;
        }

        if (authHeader == null || !authHeader.startsWith(BEARER_PREFIX)) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }

        String token = authHeader.substring(BEARER_PREFIX.length());
        
        try {
            // Token doğrulama işlemi burada yapılacak
            validateToken(token);
            return true;
        } catch (Exception e) {
            log.error("Token validation failed: {}", e.getMessage());
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
    }

    private boolean isPublicEndpoint(HttpServletRequest request) {
        String path = request.getRequestURI();
        return path.startsWith("/api/public") || 
               path.equals("/api/auth/login") ||
               path.equals("/api/auth/register");
    }

    private void validateToken(String token) {
        // Token doğrulama mantığı burada implement edilecek
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Invalid token");
        }
    }
} 