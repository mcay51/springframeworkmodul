# Spring Framework Modül Geliştirme Kontrol Listesi

## Her Yeni Modül İçin Yapılacaklar

### 1. Proje Yapısı
- [ ] Ana pom.xml'e yeni modülü ekle
- [ ] Modül için pom.xml oluştur
- [ ] Gerekli dependencies ekle
- [ ] Proje paket yapısını oluştur

### 2. Kod Geliştirme
- [ ] Her sınıf için detaylı Javadoc yorumları ekle
- [ ] Her metod için açıklayıcı yorumlar ekle
- [ ] Kod içi açıklayıcı yorumlar ekle
- [ ] Best practice'lere uygun kod yaz
- [ ] Interface tabanlı tasarım yap
- [ ] Katmanlı mimari yapısında model sınıflarını entity klasörü altında konumlandır

### 3. Katmanlar
- [ ] Controller katmanı
- [ ] Service katmanı
- [ ] Repository katmanı
- [ ] Entity sınıfları
- [ ] DTO sınıfları
- [ ] MapStruct mapper sınıfları
- [ ] Exception handling
- [ ] Validation

### 4. Mapping İşlemleri
- [ ] MapStruct bağımlılığı ekle
- [ ] Entity -> DTO dönüşüm metodları
- [ ] DTO -> Entity dönüşüm metodları
- [ ] Custom mapping metodları (gerekirse)
- [ ] Mapping test sınıfları

### 5. README.md
- [ ] Modül açıklaması
- [ ] Proje yapısı
- [ ] Özellikler
- [ ] Nasıl çalışır
- [ ] Önemli kavramlar
- [ ] Teknolojiler
- [ ] Çalıştırma talimatları
- [ ] Test talimatları
- [ ] Örnek çıktılar

### 6. Veritabanı (Gerekirse)
- [ ] Docker PostgreSQL bağlantısı (username: postgres, password: postgres)
- [ ] SQL scriptleri
- [ ] Entity sınıfları
- [ ] Repository katmanı

### 7. Test
- [ ] Unit testler
- [ ] Integration testler
- [ ] Test coverage kontrolü
- [ ] Controller testleri
- [ ] Service testleri
- [ ] Repository testleri
- [ ] DTO converter testleri

### 8. Dokümantasyon
- [ ] API dokümantasyonu
- [ ] Swagger/OpenAPI dokümantasyonu
- [ ] Kurulum talimatları
- [ ] Örnek kullanım senaryoları
- [ ] Postman collection

### 9. Final Kontrol
- [ ] Kod kalite kontrolü
- [ ] README.md kontrolü
- [ ] Test sonuçları kontrolü
- [ ] Build kontrolü
- [ ] API dokümantasyon kontrolü
- [ ] Exception handling kontrolü
- [ ] Validation kontrolü 