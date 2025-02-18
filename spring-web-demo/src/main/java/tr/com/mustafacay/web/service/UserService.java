package tr.com.mustafacay.web.service;

import tr.com.mustafacay.web.dto.UserDto;
import java.util.List;

/**
 * Kullanıcı işlemlerini yöneten servis arayüzü
 */
public interface UserService {
    
    /**
     * Yeni kullanıcı oluşturur
     * @param userDto kullanıcı bilgileri
     * @return oluşturulan kullanıcı
     */
    UserDto createUser(UserDto userDto);
    
    /**
     * ID'ye göre kullanıcı getirir
     * @param id kullanıcı ID'si
     * @return bulunan kullanıcı
     */
    UserDto getUserById(Long id);
    
    /**
     * Tüm kullanıcıları listeler
     * @return kullanıcı listesi
     */
    List<UserDto> getAllUsers();
    
    /**
     * Kullanıcı bilgilerini günceller
     * @param id güncellenecek kullanıcı ID'si
     * @param userDto yeni kullanıcı bilgileri
     * @return güncellenen kullanıcı
     */
    UserDto updateUser(Long id, UserDto userDto);
    
    /**
     * Kullanıcıyı siler
     * @param id silinecek kullanıcı ID'si
     */
    void deleteUser(Long id);
} 