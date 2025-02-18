# Spring Data Access/Integration Demo

Bu modül, Spring Framework'ün veri erişim ve entegrasyon özelliklerini göstermektedir.

## Proje Yapısı 

## Özellikler

1. **JPA/Hibernate Entegrasyonu**
   - Entity sınıfları
   - Repository pattern
   - CRUD operasyonları
   - Özel sorgular

2. **Transaction Yönetimi**
   - @Transactional annotation
   - Rollback mekanizması
   - İzolasyon seviyeleri

3. **PostgreSQL Entegrasyonu**
   - Bağlantı yapılandırması
   - DDL otomatik oluşturma
   - SQL loglama

## Nasıl Çalışır

1. PostgreSQL veritabanı başlatılır
2. Spring Boot uygulaması başlatılır
3. Hibernate şemaları oluşturur
4. Repository ve Service katmanları üzerinden veritabanı işlemleri gerçekleştirilir

## Önemli Kavramlar

- **Entity**: Veritabanı tablosunu temsil eden sınıf
- **Repository**: Veritabanı işlemlerini soyutlayan arayüz
- **Transaction**: Atomik işlem birimi
- **JPA**: Java Persistence API
- **Hibernate**: ORM framework

## Teknolojiler

- Java 17
- Spring Boot 3.2.3
- Spring Data JPA
- PostgreSQL
- Hibernate
- Maven

## Veritabanı Kurulumu

Docker ile PostgreSQL başlatma:

```bash
docker run --name postgres-db -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres
```

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
Hibernate: create table products (...)
Hibernate: insert into products (...)
Ürün kaydedildi: Test Ürünü
Ürün: Test Ürünü, Fiyat: 99.99
```

