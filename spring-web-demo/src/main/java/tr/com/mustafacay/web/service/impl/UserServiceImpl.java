package tr.com.mustafacay.web.service.impl;

import org.springframework.stereotype.Service;
import tr.com.mustafacay.web.dto.UserDto;
import tr.com.mustafacay.web.exception.UserNotFoundException;
import tr.com.mustafacay.web.entity.User;
import tr.com.mustafacay.web.service.UserService;
import tr.com.mustafacay.web.mapper.UserMapper;
import tr.com.mustafacay.web.repository.UserRepository;

import java.util.List;

/**
 * UserService implementasyonu
 * Örnek olarak in-memory veri saklama kullanılmıştır
 */
@Service
public class UserServiceImpl implements UserService {
    
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    
    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }
    
    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("Kullanıcı bulunamadı: " + id));
        return userMapper.toDto(user);
    }
    
    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
            .map(userMapper::toDto)
            .toList();
    }
    
    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("Güncellenecek kullanıcı bulunamadı: " + id);
        }
        
        User user = userMapper.toEntity(userDto);
        user.setId(id);
        user = userRepository.save(user);
        
        return userMapper.toDto(user);
    }
    
    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("Silinecek kullanıcı bulunamadı: " + id);
        }
        userRepository.deleteById(id);
    }
} 