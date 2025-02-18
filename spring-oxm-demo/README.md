# Spring OXM Demo

Bu proje, Spring Framework'ün OXM (Object/XML Mapping) modülünü göstermektedir.

## OXM Nedir?

Spring OXM, Java nesneleri ile XML arasında dönüşüm yapmayı sağlayan bir modüldür. Bu modül, farklı XML binding teknolojilerini (JAXB, Castor, XStream vb.) destekler.

## Özellikler

1. Marshalling (Object -> XML)
   - Java nesnelerini XML'e dönüştürme
   - Özelleştirilebilir XML yapısı
   - Annotation tabanlı yapılandırma

2. Unmarshalling (XML -> Object)
   - XML'i Java nesnelerine dönüştürme
   - Şema validasyonu
   - Namespace desteği

3. Desteklenen Teknolojiler
   - JAXB
   - Castor
   - JiBX
   - XStream

## Proje Yapısı

```
src/main/java/
  └── tr/com/mustafacay/oxm/
      ├── model/
      │   └── Customer.java
      ├── service/
      │   └── XmlConverterService.java
      └── SpringOxmDemoApplication.java
```

## Kurulum

1. Maven Dependency:
```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-oxm</artifactId>
</dependency>
```

## Örnek Kullanım

1. Model Sınıfı:
```java
@XmlRootElement
public class Customer {
    private String name;
    // getters/setters
}
```

2. XML Dönüşümü:
```java
// Object -> XML
String xml = xmlConverterService.objectToXml(customer);

// XML -> Object
Customer customer = xmlConverterService.xmlToObject(xml);
```

## Notlar

1. JAXB için uygun annotations gereklidir
2. Namespace yönetimi önemlidir
3. Şema validasyonu önerilir
4. Performance için caching kullanılabilir 