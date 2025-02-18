package tr.com.mustafacay.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.mustafacay.security.entity.Role;
import tr.com.mustafacay.security.entity.RoleType;

import java.util.Optional;

/**
 * Role entity'si için repository interface
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
    /**
     * Rol adına göre rol arar
     */
    Optional<Role> findByName(RoleType name);
    
    /**
     * Rol adının var olup olmadığını kontrol eder
     */
    boolean existsByName(RoleType name);
} 