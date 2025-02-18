package tr.com.mustafacay.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.mustafacay.security.entity.User;

import java.util.Optional;

/**
 * User entity'si için repository interface
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    /**
     * Username'e göre kullanıcı arar
     */
    Optional<User> findByUsername(String username);
    
    /**
     * Email'e göre kullanıcı arar
     */
    Optional<User> findByEmail(String email);
    
    /**
     * Username veya email'e göre kullanıcının var olup olmadığını kontrol eder
     */
    boolean existsByUsernameOrEmail(String username, String email);
    
    /**
     * Username'in kullanımda olup olmadığını kontrol eder
     */
    boolean existsByUsername(String username);
    
    /**
     * Email'in kullanımda olup olmadığını kontrol eder
     */
    boolean existsByEmail(String email);
} 