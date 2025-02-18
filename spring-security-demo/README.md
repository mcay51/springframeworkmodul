# Spring Security Demo

Bu modül, Spring Security ve JWT kullanarak authentication ve authorization işlemlerini göstermektedir.

## Özellikler

- JWT tabanlı authentication
- Role tabanlı authorization
- User ve Role entity'leri
- PostgreSQL veritabanı entegrasyonu
- RESTful API endpoints
- Swagger/OpenAPI dokümantasyonu

## Proje Yapısı

### Entity Katmanı

1. User Entity
```java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    
    @NotBlank
    @Email
    private String email;
    
    @NotBlank
    private String password;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();
    
    // Getter ve Setter metodları
}
```

2. Role Entity
```java
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleType name;
    
    // Getter ve Setter metodları
}
```

3. RoleType Enum
```java
public enum RoleType {
    ROLE_USER,
    ROLE_ADMIN,
    ROLE_MODERATOR
}
```

### Veritabanı Şeması

1. users tablosu
   - id (Primary Key)
   - username (Unique)
   - email (Unique)
   - password
   
2. roles tablosu
   - id (Primary Key)
   - name (Unique)
   
3. user_roles tablosu (Many-to-Many ilişki)
   - user_id (Foreign Key)
   - role_id (Foreign Key)

## Kurulum

1. PostgreSQL veritabanını oluşturun:
```sql
CREATE DATABASE springdatadb;
CREATE SCHEMA springsecuritydb;
CREATE SCHEMA springsecuritydb_test;
```

2. application.properties dosyasındaki veritabanı ayarlarını güncelleyin
3. Projeyi derleyin: `mvn clean install`
4. Uygulamayı çalıştırın: `mvn spring-boot:run`

## Kullanım Örnekleri

### 1. Yeni Kullanıcı Kaydı

```bash
curl -X POST http://localhost:8082/api/auth/signup \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser",
    "email": "test@example.com",
    "password": "password123",
    "roles": ["user"]
  }'
```

Başarılı yanıt:
```json
{
  "message": "User registered successfully!"
}
```

### 2. Kullanıcı Girişi

```bash
curl -X POST http://localhost:8082/api/auth/signin \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser",
    "password": "password123"
  }'
```

Başarılı yanıt:
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "type": "Bearer",
  "id": 1,
  "username": "testuser",
  "email": "test@example.com",
  "roles": ["ROLE_USER"]
}
```

### 3. JWT Token Kullanımı

Protected bir endpoint'e istek:
```bash
curl -X GET http://localhost:8082/api/test/user \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9..."
```

## Swagger/OpenAPI

API dokümantasyonuna erişmek için:
http://localhost:8082/swagger-ui.html

## Postman Collection

Test için hazır Postman collection'ı `postman` klasöründe bulabilirsiniz.

## Güvenlik Notları

1. JWT token'ları 24 saat geçerlidir
2. Şifreler BCrypt ile hashlenir
3. Role-based authorization kullanılmaktadır
4. Cross-Origin Resource Sharing (CORS) yapılandırılmıştır

## Test

Testleri çalıştırmak için: `mvn test` 