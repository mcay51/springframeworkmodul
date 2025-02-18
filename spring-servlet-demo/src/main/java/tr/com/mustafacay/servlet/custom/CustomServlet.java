package tr.com.mustafacay.servlet.custom;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Özel Servlet örneği
 * /custom-servlet URL'ine gelen istekleri işler
 */
@WebServlet(name = "customServlet", urlPatterns = "/custom-servlet")
public class CustomServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h1>Custom Servlet Response</h1>");
    }
} 