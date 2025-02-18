package tr.com.mustafacay.security.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tr.com.mustafacay.security.entity.Role;
import tr.com.mustafacay.security.entity.RoleType;
import tr.com.mustafacay.security.repository.RoleRepository;

/**
 * Uygulama başlangıcında gerekli verileri yükleyen sınıf
 */
@Component
public class DataInitializer implements CommandLineRunner {
    
    private final RoleRepository roleRepository;
    
    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    
    @Override
    public void run(String... args) {
        // Roller yoksa oluştur
        for (RoleType roleType : RoleType.values()) {
            if (!roleRepository.existsByName(roleType)) {
                Role role = new Role(roleType);
                roleRepository.save(role);
            }
        }
    }
} 