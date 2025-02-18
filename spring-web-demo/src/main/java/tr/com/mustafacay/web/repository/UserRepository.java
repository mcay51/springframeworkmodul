package tr.com.mustafacay.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.mustafacay.web.entity.User;

import java.util.List;

/**
 * User entity'si için repository interface
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    /**
     * İsme göre kullanıcı arar (case-insensitive)
     */
    List<User> findByNameContainingIgnoreCase(String name);
    
    /**
     * Email adresine göre kullanıcı bulur
     */
    boolean existsByEmail(String email);
    
    /**
     * Aktif kullanıcıları listeler
     */
    List<User> findByActiveTrue();
} 