# Spring Servlet Demo

Bu proje, Spring Framework'ün Servlet modülünü göstermektedir.

## Spring Servlet Nedir?

Spring Servlet modülü, Java Servlet API'sini kullanarak web uygulamaları geliştirmek için gerekli altyapıyı sağlar. Servlet'ler, HTTP isteklerini işleyen Java sınıflarıdır.

## Özellikler

1. Servlet Desteği
   - HttpServlet sınıfından türetilen özel servlet'ler
   - URL pattern eşleştirme
   - Request/Response işleme

2. Filter Desteği
   - İstek/yanıt zincirini değiştirme
   - Cross-cutting concerns (loglama, güvenlik vb.)
   - URL pattern bazlı filtreleme

3. Listener Desteği
   - ServletContext olaylarını dinleme
   - Session olaylarını dinleme
   - Request olaylarını dinleme

## Proje Yapısı

```
src/main/java/
  └── tr/com/mustafacay/servlet/
      ├── controller/
      │   └── HomeController.java
      ├── custom/
      │   └── CustomServlet.java
      ├── filter/
      │   └── RequestLoggingFilter.java
      ├── listener/
      │   └── CustomContextListener.java
      └── SpringServletDemoApplication.java
```

## Kurulum

1. Maven Dependency:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

## Örnek Kullanım

1. Özel Servlet:
```java
@WebServlet("/custom-servlet")
public class CustomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, 
                        HttpServletResponse response) {
        // Implementation
    }
}
```

2. Filter:
```java
@WebFilter("/*")
public class RequestLoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, 
                        ServletResponse response, 
                        FilterChain chain) {
        // Implementation
    }
}
```

3. Listener:
```java
@WebListener
public class CustomContextListener 
        implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Implementation
    }
}
```

## Notlar

1. @ServletComponentScan gereklidir
2. Filter sıralaması önemlidir
3. Servlet 6.0+ için Jakarta EE kullanılır
4. Spring Boot otomatik yapılandırma sağlar

## API Dokümantasyonu

Swagger UI üzerinden API dokümantasyonuna erişmek için:

1. Uygulamayı başlatın
2. Tarayıcıda http://localhost:8080/swagger-ui.html adresine gidin

### Swagger/OpenAPI Özellikleri

1. API Endpoint'leri
   - Tüm endpoint'lerin listesi
   - HTTP metodları
   - Request/Response örnekleri

2. API Gruplandırma
   - Tag'ler ile endpoint'leri gruplandırma
   - Alfabetik sıralama
   - Metod bazlı sıralama

3. Swagger UI
   - İnteraktif API dokümantasyonu
   - API'leri test etme imkanı
   - Request/Response şemalarını görüntüleme 