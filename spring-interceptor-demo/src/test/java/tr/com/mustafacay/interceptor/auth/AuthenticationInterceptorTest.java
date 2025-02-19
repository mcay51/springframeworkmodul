package tr.com.mustafacay.interceptor.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthenticationInterceptorTest {

    private HandlerInterceptor interceptor;
    private HttpServletRequest request;
    private HttpServletResponse response;

    @BeforeEach
    public void setUp() {
        interceptor = new AuthenticationInterceptor();
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
    }

    @Test
    public void testPreHandleWithValidToken() throws Exception {
        Mockito.when(request.getHeader("Authorization")).thenReturn("Bearer valid_token");
        boolean result = interceptor.preHandle(request, response, new Object());
        assertTrue(result);
    }

    @Test
    public void testPreHandleWithInvalidToken() throws Exception {
        Mockito.when(request.getHeader("Authorization")).thenReturn(null);
        boolean result = interceptor.preHandle(request, response, new Object());
        assertFalse(result);
        Mockito.verify(response).setStatus(HttpStatus.UNAUTHORIZED.value());
    }
} 