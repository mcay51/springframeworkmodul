package tr.com.mustafacay.interceptor.logging;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.HandlerInterceptor;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RequestResponseLoggingInterceptorTest {

    private HandlerInterceptor interceptor;
    private HttpServletRequest request;
    private HttpServletResponse response;

    @BeforeEach
    public void setUp() {
        interceptor = new RequestResponseLoggingInterceptor();
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
    }

    @Test
    public void testPreHandle() throws Exception {
        Mockito.when(request.getRequestURI()).thenReturn("/api/test");
        boolean result = interceptor.preHandle(request, response, new Object());
        assertTrue(result);
    }
} 