# Spring Expression Language (SpEL) Demo

## Genel Bakış
Bu modül, Spring Framework'ün SpEL (Spring Expression Language) özelliğini demonstre eder. SpEL, runtime'da dinamik olarak ifadeleri değerlendirme yeteneği sağlayan güçlü bir bileşendir. Bu demo projesi, SpEL'in temel kullanım senaryolarını ve özelliklerini gösterir.

## Proje Yapısı

## API Dokümantasyonu
Detaylı API dokümantasyonu için: http://localhost:8080/swagger-ui.html

## Özellikler
- SpEL ifadelerinin runtime'da değerlendirilmesi
- Farklı veri tiplerinde sonuç dönüşü (String, Number, Boolean vb.)
- Context tabanlı değerlendirme desteği
- Hata yönetimi ve özel exception handling
- REST API üzerinden kolay kullanım
- Detaylı loglama ve hata raporlama

## Nasıl Çalışır
SpEL, aşağıdaki temel bileşenlerle çalışır:
1. **ExpressionParser**: SpEL ifadelerini ayrıştırır
2. **Expression**: Ayrıştırılmış ifadeyi temsil eder
3. **EvaluationContext**: İfadenin değerlendirileceği bağlamı sağlar



## Katkıda Bulunma
1. Fork yapın
2. Feature branch oluşturun (`git checkout -b feature/amazing-feature`)
3. Değişikliklerinizi commit edin (`git commit -m 'feat: Add amazing feature'`)
4. Branch'inizi push edin (`git push origin feature/amazing-feature`)
5. Pull Request oluşturun 