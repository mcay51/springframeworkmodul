# Spring Transaction Demo

Bu proje, Spring Framework'ün Transaction modülünü göstermektedir.

## Transaction Nedir?

Spring Transaction, veritabanı işlemlerinin ACID (Atomicity, Consistency, Isolation, Durability) prensiplerini sağlayacak şekilde yönetilmesini sağlayan bir modüldür.

## Özellikler

1. Declarative Transaction Management
   - @Transactional annotation kullanımı
   - AOP tabanlı transaction yönetimi
   - Transaction özellikleri (propagation, isolation, timeout vb.)

2. Programmatic Transaction Management
   - TransactionTemplate kullanımı
   - PlatformTransactionManager ile manuel kontrol
   - Transaction callback'leri

3. Transaction Propagation Levels
   - REQUIRED
   - REQUIRES_NEW
   - SUPPORTS
   - NOT_SUPPORTED
   - MANDATORY
   - NEVER
   - NESTED

## Proje Yapısı

```
src/main/java/
  └── tr/com/mustafacay/transaction/
      ├── entity/
      │   └── Account.java
      ├── repository/
      │   └── AccountRepository.java
      ├── service/
      │   └── BankService.java
      └── SpringTransactionDemoApplication.java
```

## Kurulum

1. PostgreSQL veritabanını oluşturun:
```sql
CREATE SCHEMA springtransactiondb;
```

2. Maven Dependency:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

## Örnek Kullanım

1. Declarative Transaction:
```java
@Transactional
public void transfer(String from, String to, BigDecimal amount) {
    // Implementation
}
```

2. Programmatic Transaction:
```java
TransactionTemplate template = new TransactionTemplate(transactionManager);
template.execute(status -> {
    // Implementation
    return null;
});
```
Farklı izolasyon seviyeleri (SERIALIZABLE, READ_COMMITTED vb.)
Farklı propagasyon seviyeleri (REQUIRED, REQUIRES_NEW, NESTED vb.)
Timeout ve rollback yönetimi
Read-only transactions
Programmatic transaction yönetimi
Nested transactions
Transaction logging
Özel exception handling

## Notlar

1. Transaction sınırları doğru belirlenmelidir
2. Propagation level'ları dikkatli seçilmelidir
3. Exception handling önemlidir
4. Performance için transaction süreleri optimize edilmelidir 

## API Dokümantasyonu

Swagger UI üzerinden API dokümantasyonuna erişmek için:

1. Uygulamayı başlatın
2. Tarayıcıda http://localhost:8080/swagger-ui.html adresine gidin

### API Endpoint'leri

1. POST /api/bank/transfer/high-isolation
   - Yüksek izolasyonlu para transferi
   - SERIALIZABLE izolasyon seviyesi
   - Özel exception handling

2. POST /api/bank/transfer/new-transaction
   - Yeni transaction ile para transferi
   - REQUIRES_NEW propagation
   - Exception durumunda rollback yok

3. POST /api/bank/transfer/with-logging
   - Loglama ile para transferi
   - Nested transaction örneği
   - Transfer ve log işlemleri ayrı transaction'larda

4. POST /api/bank/transfer/programmatic
   - Programmatic transaction ile transfer
   - Manuel transaction yönetimi
   - TransactionTemplate kullanımı

5. GET /api/bank/accounts
   - Tüm hesapları listele
   - Read-only transaction
   - Optimize edilmiş okuma işlemi 