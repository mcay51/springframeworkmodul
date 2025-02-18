package tr.com.mustafacay.context.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.mustafacay.context.di.ComplexService;
import tr.com.mustafacay.context.env.EnvironmentDemo;
import tr.com.mustafacay.context.event.CustomEvent;
import tr.com.mustafacay.context.lifecycle.AdvancedLifecycleBean;
import tr.com.mustafacay.context.resource.ResourceDemo;
import tr.com.mustafacay.context.scope.PrototypeBean;
import tr.com.mustafacay.context.scope.RequestScopedBean;
import tr.com.mustafacay.context.scope.SingletonBean;
import tr.com.mustafacay.context.validation.UserDto;

import jakarta.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/api/demo")
@Tag(name = "Spring Context Demo", description = "Spring Context özelliklerini test etmek için API endpoint'leri")
public class DemoController {

    @Autowired
    private MessageSource messageSource;
    
    @Autowired
    private RequestScopedBean requestScopedBean;
    
    @Autowired
    private SingletonBean singletonBean;
    
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    
    @Autowired
    private EnvironmentDemo environmentDemo;
    
    @Autowired
    private ResourceDemo resourceDemo;
    
    @Autowired
    private ComplexService complexService;
    
    @Autowired
    private AdvancedLifecycleBean lifecycleBean;
    
    // Prototype bean'i her istekte yeni oluşturulacak
    @Autowired
    private PrototypeBean prototypeBean;

    @Operation(summary = "I18n Test", description = "Farklı dillerde karşılama mesajı")
    @GetMapping("/greeting")
    public ResponseEntity<Map<String, String>> getGreeting(
            @Parameter(description = "Kullanıcı adı")
            @RequestParam(required = false) String name,
            @Parameter(description = "Dil kodu (tr/en)")
            @RequestParam(required = false) String lang) {
        
        Locale locale = lang != null ? new Locale(lang) : LocaleContextHolder.getLocale();
        String welcome = messageSource.getMessage("welcome", 
            new Object[]{name != null ? name : "Guest"}, locale);
        
        Map<String, String> response = new HashMap<>();
        response.put("message", welcome);
        response.put("locale", locale.toString());
        
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Scope Test", description = "Farklı scope'lardaki bean'leri test eder")
    @GetMapping("/scopes")
    public ResponseEntity<Map<String, String>> testScopes() {
        Map<String, String> scopes = new HashMap<>();
        scopes.put("singleton", singletonBean.getMessage());
        scopes.put("prototype", prototypeBean.getMessage());
        scopes.put("request", requestScopedBean.getData());
        return ResponseEntity.ok(scopes);
    }

    @Operation(summary = "Event Test", description = "Custom event yayınlar")
    @PostMapping("/events")
    public ResponseEntity<String> publishEvent(
            @Parameter(description = "Event mesajı")
            @RequestParam String message) {
        eventPublisher.publishEvent(new CustomEvent(this, message));
        return ResponseEntity.ok("Event published: " + message);
    }

    @Operation(summary = "Environment Test", description = "Environment ve profil bilgilerini gösterir")
    @GetMapping("/environment")
    public ResponseEntity<Map<String, String>> getEnvironmentInfo() {
        Map<String, String> envInfo = new HashMap<>();
        envInfo.put("activeProfiles", environmentDemo.getActiveProfiles());
        envInfo.put("appName", environmentDemo.getProperty("app.name"));
        envInfo.put("appVersion", environmentDemo.getProperty("app.version"));
        return ResponseEntity.ok(envInfo);
    }

    @Operation(summary = "Resource Test", description = "Kaynak dosyasını okur")
    @GetMapping("/resources")
    public ResponseEntity<String> readResource() throws IOException {
        return ResponseEntity.ok(resourceDemo.readResource());
    }

    @Operation(summary = "Validation Test", description = "DTO validasyonunu test eder")
    @PostMapping("/users")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok("User validated and created: " + userDto.getName());
    }

    @Operation(summary = "DI Test", description = "Dependency Injection örneklerini test eder")
    @GetMapping("/di")
    public ResponseEntity<String> testDI() {
        return ResponseEntity.ok(complexService.executeAllServices());
    }

    @Operation(summary = "Lifecycle Test", description = "Bean lifecycle'ını test eder")
    @PostMapping("/lifecycle")
    public ResponseEntity<String> testLifecycle() {
        lifecycleBean.customInit();
        return ResponseEntity.ok("Lifecycle methods executed");
    }
} 