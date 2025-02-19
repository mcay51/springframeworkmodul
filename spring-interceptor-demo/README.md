# Spring Interceptor Demo

## Genel Bakış
Bu modül, Spring Framework'ün Interceptor mekanizmasını demonstre eder. HTTP isteklerini işlemeden önce veya sonra çeşitli kontroller ve işlemler yapmayı sağlayan interceptor'ların kullanımını gösterir.

## Proje Yapısı 
src/main/java/tr/com/mustafacay/interceptor/
├── annotation/
│ ├── RequiresRole.java # Rol bazlı yetkilendirme annotation'ı
│ └── RoleBasedInterceptor.java # Rol kontrolü yapan interceptor
├── auth/
│ └── AuthenticationInterceptor.java # Kimlik doğrulama interceptor'ı
├── performance/
│ ├── PerformanceInterceptor.java # Performans ölçüm interceptor'ı
│ └── PerformanceMetrics.java # Performans metrikleri sınıfı
├── logging/
│ └── RequestResponseLoggingInterceptor.java # Detaylı loglama interceptor'ı
├── filter/
│ └── ContentCachingFilter.java # Request/Response body caching filter'ı
├── config/
│ └── WebMvcConfig.java # Interceptor konfigürasyonları
└── controller/
├── AuthTestController.java # Test endpoint'leri
└── PerformanceController.java # Performans metrikleri endpoint'leri

## Özellikler
1. **Authentication Interceptor**
   - Bearer token kontrolü
   - Public endpoint'ler için bypass
   - Unauthorized durumları için hata yönetimi

2. **Performance Monitoring Interceptor**
   - İstek süre ölçümü
   - Endpoint bazlı performans metrikleri
   - Min/Max/Ortalama süre hesaplama
   - İstek sayısı takibi

3. **Request/Response Logging Interceptor**
   - Detaylı istek/yanıt loglaması
   - HTTP headers takibi
   - Request/Response body loglaması
   - Path bazlı filtreleme

4. **Role Based Interceptor**
   - Annotation tabanlı rol kontrolü
   - Metod ve sınıf seviyesinde yetkilendirme
   - Çoklu rol desteği
   - Esnek rol kontrolü (anyRole özelliği)

## Teknolojiler
- Java 17
- Spring Boot 3.2.3
- Spring Web MVC
- Lombok
- SLF4J (Loglama)

## Kurulum
1. Projeyi klonlayın:
```
git clone https://github.com/username/spring-framework.git
```

2. Proje dizinine gidin:
```
cd spring-framework/spring-interceptor-demo
```

3. Uygulamayı derleyin:
```
mvn clean install
```

4. Uygulamayı çalıştırın:
```
mvn spring-boot:run
```

## Test
Örnek istekler için Postman collection'ı kullanabilirsiniz:

1. Public endpoint testi:
```
curl http://localhost:8080/api/public/test
```

2. Admin endpoint testi:
```
curl -H "Authorization: Bearer token123" \
     -H "X-User-Role: ADMIN" \
     http://localhost:8080/api/admin/test
```

3. User endpoint testi:
```
curl -H "Authorization: Bearer token123" \
     -H "X-User-Role: USER" \
     http://localhost:8080/api/user/test
```

## Önemli Notlar
- Interceptor'ların sıralaması önemlidir
- Performance interceptor gereksiz yere kullanılmamalıdır
- Loglama seviyesi production ortamında dikkatli ayarlanmalıdır
- Role based yetkilendirme gerçek uygulamada security context ile entegre edilmelidir

## Katkıda Bulunma
1. Fork yapın
2. Feature branch oluşturun (`git checkout -b feature/amazing-feature`)
3. Değişikliklerinizi commit edin (`git commit -m 'feat: Add amazing feature'`)
4. Branch'inizi push edin (`git push origin feature/amazing-feature`)
5. Pull Request oluşturun

## Lisans
Bu proje MIT lisansı altında lisanslanmıştır. Detaylar için [LICENSE](LICENSE) dosyasına bakınız.