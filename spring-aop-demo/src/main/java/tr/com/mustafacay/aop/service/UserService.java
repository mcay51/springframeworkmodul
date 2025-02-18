package tr.com.mustafacay.aop.service;

import org.springframework.stereotype.Service;

/**
 * Kullanıcı işlemlerini yöneten servis sınıfı.
 * Bu sınıf üzerinde AOP ile loglama ve performans ölçümü yapılacak.
 */
@Service
public class UserService {
    
    /**
     * Yeni kullanıcı oluşturma metodu
     * @param username oluşturulacak kullanıcının adı
     */
    public void createUser(String username) {
        // Gerçek uygulamada burada veritabanı işlemleri olacak
        System.out.println("Kullanıcı oluşturuldu: " + username);
    }
    
    /**
     * Kullanıcı silme metodu
     * @param username silinecek kullanıcının adı
     */
    public void deleteUser(String username) {
        // Gerçek uygulamada burada veritabanı işlemleri olacak
        System.out.println("Kullanıcı silindi: " + username);
    }
} 