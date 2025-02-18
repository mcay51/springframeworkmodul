package tr.com.mustafacay.servlet.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Ana sayfa controller'ı
 */
@Controller
@Tag(name = "Home", description = "Ana sayfa endpoint'leri")
public class HomeController {
    
    @Operation(
        summary = "Ana sayfa",
        description = "Karşılama mesajını döndürür",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Başarılı"
            )
        }
    )
    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "Welcome to Spring Servlet Demo!";
    }
} 