package tr.com.mustafacay.web.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import tr.com.mustafacay.web.entity.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(scripts = "classpath:init-test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByNameContainingIgnoreCase_Success() {
        // When
        List<User> users = userRepository.findByNameContainingIgnoreCase("test");

        // Then
        assertFalse(users.isEmpty());
        assertTrue(users.stream().anyMatch(user -> user.getName().toLowerCase().contains("test")));
    }

    @Test
    void existsByEmail_Success() {
        // Given
        String email = "test@example.com";
        User user = new User();
        user.setName("Test User");
        user.setEmail(email);
        user.setPhone("5551234567");
        user.setActive(true);
        userRepository.save(user);

        // When
        boolean exists = userRepository.existsByEmail(email);

        // Then
        assertTrue(exists);
    }

    @Test
    void findByActiveTrue_Success() {
        // Given
        User activeUser = new User();
        activeUser.setName("Active User");
        activeUser.setEmail("active@example.com");
        activeUser.setPhone("5551234567");
        activeUser.setActive(true);
        userRepository.save(activeUser);

        User inactiveUser = new User();
        inactiveUser.setName("Inactive User");
        inactiveUser.setEmail("inactive@example.com");
        inactiveUser.setPhone("5557654321");
        inactiveUser.setActive(false);
        userRepository.save(inactiveUser);

        // When
        List<User> activeUsers = userRepository.findByActiveTrue();

        // Then
        assertFalse(activeUsers.isEmpty());
        assertTrue(activeUsers.stream().allMatch(User::isActive));
    }
} 