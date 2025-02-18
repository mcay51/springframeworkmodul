# Spring Instrumentation Demo

Bu proje, Spring Framework'ün Instrumentation modülünü göstermektedir.

## Instrumentation Nedir?

Spring Instrumentation, Java sınıflarının yükleme zamanında (load-time) veya çalışma zamanında (runtime) değiştirilmesini sağlayan bir modüldür. Bu özellik özellikle AOP (Aspect-Oriented Programming) uygulamalarında kullanılır.

## Özellikler

1. Load-Time Weaving (LTW)
   - Sınıflar JVM'e yüklenirken aspect'lerin uygulanması
   - Performans izleme gibi çapraz kesen endişelerin (cross-cutting concerns) yönetimi

2. Runtime Weaving
   - Çalışma zamanında sınıfların değiştirilmesi
   - Dinamik proxy oluşturma

3. Java Agent Desteği
   - JVM başlangıcında veya çalışma zamanında Java agent'larının yüklenmesi

## Kullanım Alanları

1. Performans İzleme
2. Güvenlik Kontrolleri
3. Loglama
4. Transaction Yönetimi
5. Cache Yönetimi

## Proje Yapısı

```
src/main/java/
  └── tr/com/mustafacay/instrumentation/
      ├── annotation/
      │   └── MonitorPerformance.java
      ├── aspect/
      │   └── PerformanceMonitoringAspect.java
      ├── service/
      │   └── ExampleService.java
      └── SpringInstrumentationDemoApplication.java
```

## Kurulum

1. JVM Argümanları Ekleme:
```bash
-javaagent:/path/to/spring-instrument.jar
```

2. Maven Dependency:
```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-instrument</artifactId>
</dependency>
```

## Örnek Kullanım

```java
@Service
public class ExampleService {
    
    @MonitorPerformance
    public void slowOperation() {
        // Method implementation
    }
}
```

## Notlar

1. Load-time weaving için JVM argümanlarının doğru yapılandırılması gerekir
2. Performans etkisi göz önünde bulundurulmalıdır
3. Test ortamında farklı yapılandırma gerekebilir 