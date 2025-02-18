package tr.com.mustafacay.web.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tr.com.mustafacay.web.dto.UserDto;
import tr.com.mustafacay.web.entity.User;
import tr.com.mustafacay.web.exception.UserNotFoundException;
import tr.com.mustafacay.web.mapper.UserMapper;
import tr.com.mustafacay.web.repository.UserRepository;
import tr.com.mustafacay.web.service.impl.UserServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    private User testUser;
    private UserDto testUserDto;

    @BeforeEach
    void setUp() {
        testUser = new User();
        testUser.setId(1L);
        testUser.setName("Test User");
        testUser.setEmail("test@example.com");
        testUser.setPhone("5551234567");
        testUser.setActive(true);

        testUserDto = new UserDto();
        testUserDto.setId(1L);
        testUserDto.setName("Test User");
        testUserDto.setEmail("test@example.com");
        testUserDto.setPhone("5551234567");
    }

    @Test
    void createUser_Success() {
        // Given
        when(userMapper.toEntity(any(UserDto.class))).thenReturn(testUser);
        when(userRepository.save(any(User.class))).thenReturn(testUser);
        when(userMapper.toDto(any(User.class))).thenReturn(testUserDto);

        // When
        UserDto result = userService.createUser(testUserDto);

        // Then
        assertNotNull(result);
        assertEquals(testUserDto.getName(), result.getName());
        verify(userRepository).save(any(User.class));
    }

    @Test
    void getUserById_Success() {
        // Given
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        when(userMapper.toDto(testUser)).thenReturn(testUserDto);

        // When
        UserDto result = userService.getUserById(1L);

        // Then
        assertNotNull(result);
        assertEquals(testUserDto.getId(), result.getId());
        assertEquals(testUserDto.getName(), result.getName());
    }

    @Test
    void getUserById_NotFound() {
        // Given
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(UserNotFoundException.class, () -> userService.getUserById(99L));
    }

    @Test
    void getAllUsers_Success() {
        // Given
        List<User> users = Arrays.asList(testUser);
        when(userRepository.findAll()).thenReturn(users);
        when(userMapper.toDto(any(User.class))).thenReturn(testUserDto);

        // When
        List<UserDto> result = userService.getAllUsers();

        // Then
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
    }

    @Test
    void updateUser_Success() {
        // Given
        when(userRepository.existsById(1L)).thenReturn(true);
        when(userMapper.toEntity(any(UserDto.class))).thenReturn(testUser);
        when(userRepository.save(any(User.class))).thenReturn(testUser);
        when(userMapper.toDto(any(User.class))).thenReturn(testUserDto);

        // When
        UserDto result = userService.updateUser(1L, testUserDto);

        // Then
        assertNotNull(result);
        assertEquals(testUserDto.getName(), result.getName());
        verify(userRepository).save(any(User.class));
    }

    @Test
    void updateUser_NotFound() {
        // Given
        when(userRepository.existsById(99L)).thenReturn(false);

        // When & Then
        assertThrows(UserNotFoundException.class, () -> userService.updateUser(99L, testUserDto));
    }

    @Test
    void deleteUser_Success() {
        // Given
        when(userRepository.existsById(1L)).thenReturn(true);
        doNothing().when(userRepository).deleteById(1L);

        // When
        userService.deleteUser(1L);

        // Then
        verify(userRepository).deleteById(1L);
    }

    @Test
    void deleteUser_NotFound() {
        // Given
        when(userRepository.existsById(99L)).thenReturn(false);

        // When & Then
        assertThrows(UserNotFoundException.class, () -> userService.deleteUser(99L));
    }
} 