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