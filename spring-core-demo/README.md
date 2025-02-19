# Spring Core Demo Uygulaması

Bu proje, Spring Framework'ün temel özelliklerini göstermek amacıyla geliştirilmiş bir demo uygulamasıdır.

## Proje Yapısı

Proje aşağıdaki katmanlardan oluşmaktadır:

- **config**: Spring konfigürasyon sınıfları
- **controller**: Uygulama controller'ları
- **service**: Business logic'in bulunduğu servis katmanı
- **entity**: Veri modeli sınıfları (Bu projede kullanılmadı)
- **dto**: Data Transfer Object'ler (Bu projede kullanılmadı)

## Özellikler

- Dependency Injection (DI) örnekleri
- Constructor injection kullanımı
- @Qualifier annotation'ı ile bean seçimi
- Interface tabanlı gevşek bağlı (loosely coupled) tasarım
- Component Scanning (@Component, @Service)
- Spring IoC Container kullanımı
- IOC Bean Factory
-- Application Context
-- XML Bean Factory kullanımı

## Nasıl Çalışır?

Uygulama iki farklı mesaj servisi (EmailService ve SmsService) içerir. MessageController, @Qualifier ile belirtilen servisi kullanarak mesaj gönderir. Ayrıca XML konfigürasyonu ile tanımlanmış bir bean de kullanılır.

## Önemli Kavramlar

- **Inversion of Control (IoC)**: Bağımlılıkların yönetimi Spring tarafından yapılır
- **Dependency Injection (DI)**: Bağımlılıklar constructor veya setter ile enjekte edilir
- **Bean**: Spring tarafından yönetilen nesneler
- **Component Scanning**: Spring'in otomatik olarak bean'leri bulup yönetmesi

## Teknolojiler

- Java 17
- Spring Framework 6.x
- Maven

## Çalıştırma Talimatları

1. Projeyi klonlayın:
   ```bash
   git clone https://github.com/mustafacay/spring-core-demo.git
   ```
2. Proje dizinine gidin:
   ```bash
   cd spring-core-demo
   ```
3. Uygulamayı çalıştırın:
   ```bash
   mvn spring-boot:run
   ```

## Test Talimatları

Projeyi test etmek için:

## Örnek Çıktılar

Uygulama çalıştığında aşağıdaki gibi bir çıktı göreceksiniz:

Email message sent!
XML Bean Factory Message: Message from XML configured bean!