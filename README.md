# Spring Core Container Demo

Bu proje, Spring Framework'ün Core Container modülünün temel özelliklerini göstermektedir.

## Özellikler

1. **Dependency Injection (DI)**
   - Constructor injection örneği
   - @Qualifier kullanımı
   - Interface tabanlı gevşek bağlı (loosely coupled) tasarım

2. **Component Scanning**
   - @Component, @Service annotationları
   - Otomatik bean oluşturma

3. **Spring IoC Container**
   - ApplicationContext kullanımı
   - Bean lifecycle yönetimi

## Proje Yapısı

- `MessageService`: Mesaj servisi arayüzü
- `EmailService`: Email implementasyonu
- `SMSService`: SMS implementasyonu
- `MessageController`: Servis kullanımı örneği

## Nasıl Çalışır

1. Proje başlatıldığında Spring IoC Container başlar
2. Component scan ile annotated sınıflar tespit edilir
3. Dependency injection gerçekleşir
4. MessageController, EmailService'i kullanarak mesaj gösterir

## Önemli Kavramlar

- **IoC (Inversion of Control)**: Nesnelerin yaşam döngüsü kontrolünün framework'e devredilmesi
- **DI (Dependency Injection)**: Bağımlılıkların dışarıdan enjekte edilmesi
- **Bean**: Spring IoC Container tarafından yönetilen nesneler 