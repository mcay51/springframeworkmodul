package tr.com.mustafacay.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.mustafacay.web.dto.UserDto;
import tr.com.mustafacay.web.service.UserService;

import java.util.List;

/**
 * Kullanıcı işlemleri için REST controller
 */
@RestController
@RequestMapping("/api/users")
@Tag(name = "User API", description = "Kullanıcı işlemleri için REST API")
public class UserController {
    
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    /**
     * Yeni kullanıcı oluşturur
     */
    @PostMapping
    @Operation(summary = "Yeni kullanıcı oluşturur")
    @ApiResponse(responseCode = "200", description = "Kullanıcı başarıyla oluşturuldu")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.createUser(userDto));
    }
    
    /**
     * ID'ye göre kullanıcı getirir
     */
    @GetMapping("/{id}")
    @Operation(summary = "ID'ye göre kullanıcı getirir")
    @ApiResponse(responseCode = "200", description = "Kullanıcı bulundu")
    @ApiResponse(responseCode = "404", description = "Kullanıcı bulunamadı")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    
    /**
     * Tüm kullanıcıları listeler
     */
    @GetMapping
    @Operation(summary = "Tüm kullanıcıları listeler")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    
    /**
     * Kullanıcı bilgilerini günceller
     */
    @PutMapping("/{id}")
    @Operation(summary = "Kullanıcı bilgilerini günceller")
    @ApiResponse(responseCode = "200", description = "Kullanıcı başarıyla güncellendi")
    @ApiResponse(responseCode = "404", description = "Güncellenecek kullanıcı bulunamadı")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.updateUser(id, userDto));
    }
    
    /**
     * Kullanıcıyı siler
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Kullanıcıyı siler")
    @ApiResponse(responseCode = "204", description = "Kullanıcı başarıyla silindi")
    @ApiResponse(responseCode = "404", description = "Silinecek kullanıcı bulunamadı")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
} 