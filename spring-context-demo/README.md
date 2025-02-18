# Spring Context Demo

Bu proje, Spring Framework'ün Context modülünü ve özelliklerini göstermektedir. Spring Context, Spring uygulamalarının temelini oluşturan IoC (Inversion of Control) container'ı sağlar.

## İçerik

- [Proje Yapısı](#proje-yapısı)
- [Özellikler](#özellikler)
- [Teknolojiler](#teknolojiler)
- [Kurulum](#kurulum)
- [Çalıştırma](#çalıştırma)
- [API Endpoints](#api-endpoints)
- [Test](#test)
- [Önemli Kavramlar](#önemli-kavramlar)

## Proje Yapısı
```
src/main/java/tr/com/mustafacay/context/
├── binding/                  # Data binding işlemleri
│   └── DateFormatter.java
├── config/                   # Konfigürasyon sınıfları
│   ├── AppConfig.java
│   ├── I18nConfig.java
│   ├── OpenApiConfig.java
│   └── ScanningConfig.java
├── controller/              # REST controller'lar
│   └── DemoController.java
├── di/                      # Dependency Injection örnekleri
│   └── ComplexService.java
├── env/                     # Environment ve profil yönetimi
│   └── EnvironmentDemo.java
├── event/                   # Event handling
│   ├── CustomEvent.java
│   └── CustomEventListener.java
├── lifecycle/              # Bean lifecycle örnekleri
│   ├── AdvancedLifecycleBean.java
│   └── LifecycleBean.java
├── resource/               # Resource handling
│   └── ResourceDemo.java
├── scope/                  # Bean scope örnekleri
│   ├── PrototypeBean.java
│   ├── RequestScopedBean.java
│   └── SingletonBean.java
└── validation/            # Validation örnekleri
    └── UserDto.java
```

## Özellikler

### 1. Bean Lifecycle Yönetimi
- Constructor-based initialization
- @PostConstruct ve @PreDestroy
- InitializingBean ve DisposableBean
- Custom init ve destroy metodları

### 2. Dependency Injection
- Constructor injection
- Setter injection
- Field injection
- Method injection

### 3. Bean Scopes
- Singleton (varsayılan)
- Prototype
- Request
- Session
- Application
- Websocket

### 4. Configuration Management
- Java-based configuration
- Profile-based configuration
- Property management
- Environment abstraction

### 5. Event Handling
- Custom events
- Event listeners
- Asynchronous events

### 6. Resource Management
- ClassPath resources
- File system resources
- URL resources
- Resource patterns

### 7. Internationalization (i18n)
- MessageSource
- Locale yönetimi
- Resource bundles

## Teknolojiler
- Spring Boot 3.2.3
- Spring Context
- Spring Web
- Spring Validation
- Swagger/OpenAPI 2.3.0
- JUnit 5
- Maven

## Kurulum

1. Projeyi klonlayın:
```bash
git clone https://github.com/yourusername/spring-framework.git
```

2. Proje dizinine gidin:
```bash
cd spring-framework/spring-context-demo
```

3. Maven ile bağımlılıkları yükleyin:
```bash
mvn clean install
```

## Çalıştırma

1. Uygulamayı başlatın:
```bash
mvn spring-boot:run
```

2. Swagger UI'a erişin:
```
http://localhost:8084/swagger-ui.html
```

## API Endpoints

### Greeting Controller
- GET `/api/demo/greeting` - Karşılama mesajı (i18n örneği)
- GET `/api/demo/request-scope` - Request scope örneği
- POST `/api/demo/users` - Kullanıcı oluşturma (validation örneği)

## Test

1. Tüm testleri çalıştırma:
```bash
mvn test
```

2. Belirli bir test sınıfını çalıştırma:
```bash
mvn test -Dtest=DemoControllerTest
```

## Önemli Kavramlar

### IoC Container
Spring IoC container, bean'lerin yaşam döngüsünü yöneten ve dependency injection'ı sağlayan ana bileşendir.

### Bean Lifecycle
1. Instantiation
2. Populate Properties
3. BeanNameAware
4. BeanFactoryAware
5. ApplicationContextAware
6. @PostConstruct
7. InitializingBean
8. Custom Init Method
9. Bean Hazır
10. @PreDestroy
11. DisposableBean
12. Custom Destroy Method

### Bean Scopes
- **Singleton**: Her bean için tek instance
- **Prototype**: Her istekte yeni instance
- **Request**: Her HTTP isteği için yeni instance
- **Session**: Her HTTP session için yeni instance

### Profile-Based Configuration
- Development
- Production
- Test
- Custom profiles

## Katkıda Bulunma

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Lisans

Bu proje MIT lisansı altında lisanslanmıştır. Detaylar için [LICENSE](LICENSE) dosyasına bakın. 