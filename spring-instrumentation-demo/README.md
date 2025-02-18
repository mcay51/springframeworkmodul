# Spring Instrumentation Demo

Bu proje, Spring Framework'ün Instrumentation modülünü göstermektedir.

## Instrumentation Nedir?

Spring Instrumentation, Java sınıflarının yükleme zamanında (load-time) veya çalışma zamanında (runtime) değiştirilmesini sağlayan bir modüldür. Bu özellik özellikle AOP (Aspect-Oriented Programming) uygulamalarında kullanılır.

## Özellikler

1. Load-Time Weaving (LTW)
   - Sınıflar JVM'e yüklenirken aspect'lerin uygulanması
   - Performans izleme gibi çapraz kesen endişelerin (cross-cutting concerns) yönetimi

2. Runtime Weaving
   - Çalışma zamanında sınıfların değiştirilmesi
   - Dinamik proxy oluşturma

3. Java Agent Desteği
   - JVM başlangıcında veya çalışma zamanında Java agent'larının yüklenmesi

## Kullanım Alanları

1. Performans İzleme
2. Güvenlik Kontrolleri
3. Loglama
4. Transaction Yönetimi
5. Cache Yönetimi

## Proje Yapısı 