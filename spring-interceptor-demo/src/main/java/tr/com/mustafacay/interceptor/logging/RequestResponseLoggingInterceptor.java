package tr.com.mustafacay.interceptor.logging;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class RequestResponseLoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (request.getRequestURI().contains("/api")) {
            logRequest(request);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, 
                          Object handler, ModelAndView modelAndView) {
        if (request.getRequestURI().contains("/api")) {
            logResponse(response);
        }
    }

    private void logRequest(HttpServletRequest request) {
        Map<String, String> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.put(headerName, request.getHeader(headerName));
        }

        log.info("REQUEST: {} {} \nHeaders: {} \nParameters: {}", 
                request.getMethod(),
                request.getRequestURI(),
                headers,
                request.getParameterMap());

        if (request instanceof ContentCachingRequestWrapper) {
            ContentCachingRequestWrapper wrapper = (ContentCachingRequestWrapper) request;
            String requestBody = new String(wrapper.getContentAsByteArray());
            if (!requestBody.isEmpty()) {
                log.info("Request Body: {}", requestBody);
            }
        }
    }

    private void logResponse(HttpServletResponse response) {
        Map<String, String> headers = new HashMap<>();
        Collection<String> headerNames = response.getHeaderNames();
        for (String headerName : headerNames) {
            headers.put(headerName, response.getHeader(headerName));
        }

        log.info("RESPONSE: Status: {} \nHeaders: {}", 
                response.getStatus(),
                headers);

        if (response instanceof ContentCachingResponseWrapper) {
            ContentCachingResponseWrapper wrapper = (ContentCachingResponseWrapper) response;
            String responseBody = new String(wrapper.getContentAsByteArray());
            if (!responseBody.isEmpty()) {
                log.info("Response Body: {}", responseBody);
            }
        }
    }
} 