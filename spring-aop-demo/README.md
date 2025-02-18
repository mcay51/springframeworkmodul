# Spring AOP (Aspect-Oriented Programming) Demo

Bu modül, Spring Framework'ün AOP (Aspect-Oriented Programming) özelliklerini göstermektedir.

## Proje Yapısı 


## Özellikler

1. **Aspect Tanımlama**
   - @Aspect ve @Component annotationları
   - Pointcut expressions kullanımı
   - JoinPoint ve ProceedingJoinPoint kullanımı

2. **AOP Advice Türleri**
   - @Before: Metod çağrılmadan önce çalışan advice
   - @After: Metod çağrıldıktan sonra çalışan advice
   - @Around: Metod çağrısını sarmalayan advice

3. **Cross-Cutting Concerns (Çapraz Kesen İlgiler)**
   - Loglama işlemleri
   - Performans ölçümü
   - Metot çağrılarının izlenmesi

## Nasıl Çalışır

1. Spring AOP, proxy pattern kullanarak çalışır
2. @Aspect annotated sınıflar Spring tarafından tespit edilir
3. Pointcut expressions ile hangi metodların yakalanacağı belirlenir
4. Metodlar çağrıldığında aspect'ler devreye girer

## Önemli Kavramlar

- **Aspect**: Cross-cutting concern'leri kapsülleyen modül
- **Pointcut**: Hangi metodların yakalanacağını belirleyen ifade
- **Advice**: Aspect'in ne zaman çalışacağını belirten annotation
- **JoinPoint**: Metodun çağrıldığı nokta
- **ProceedingJoinPoint**: Around advice'da kullanılan, metod çağrısını kontrol eden nesne

## Teknolojiler

- Java 17
- Spring Boot 3.2.3
- Spring AOP
- AspectJ
- Maven

## Çalıştırma

```bash
mvn spring-boot:run
```

## Test

```bash
mvn test
```

## Örnek Çıktı

```bash
Metod başlamadan önce loglama: createUser
createUser metodu başladı
Kullanıcı oluşturuldu: mustafa
createUser metodu 5ms sürdü
Metod bittikten sonra loglama: createUser
Metod başlamadan önce loglama: deleteUser
deleteUser metodu başladı
Kullanıcı silindi: mustafa
deleteUser metodu 3ms sürdü
Metod bittikten sonra loglama: deleteUser
```

