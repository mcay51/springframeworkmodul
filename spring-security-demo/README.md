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

1. PostgreSQL veritabanını oluşturun
2. application.properties dosyasındaki veritabanı ayarlarını güncelleyin
3. Projeyi derleyin: `mvn clean install`
4. Uygulamayı çalıştırın: `mvn spring-boot:run`

## API Endpoints

Detaylı API dokümantasyonu için: http://localhost:8082/swagger-ui.html

## Güvenlik

- Şifreler BCrypt ile hashlenir
- JWT token'ları 24 saat geçerlidir
- Hassas endpointler role-based authorization ile korunur

## Test

Testleri çalıştırmak için: `mvn test` 