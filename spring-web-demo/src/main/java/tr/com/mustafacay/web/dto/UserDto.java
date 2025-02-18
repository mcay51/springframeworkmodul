package tr.com.mustafacay.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Kullanıcı veri transfer nesnesi
 */
@Schema(description = "Kullanıcı DTO")
public class UserDto {
    
    @Schema(description = "Kullanıcı ID")
    private Long id;
    
    @Schema(description = "Kullanıcı adı", example = "John Doe")
    @NotBlank(message = "İsim boş olamaz")
    @Size(min = 2, max = 50, message = "İsim 2-50 karakter arasında olmalıdır")
    private String name;
    
    @Schema(description = "Email adresi", example = "john@example.com")
    @NotBlank(message = "Email boş olamaz")
    @Email(message = "Geçerli bir email adresi giriniz")
    private String email;
    
    @Schema(description = "Telefon numarası", example = "5551234567")
    @NotBlank(message = "Telefon numarası boş olamaz")
    @Size(min = 10, max = 15, message = "Telefon numarası 10-15 karakter arasında olmalıdır")
    private String phone;

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
} 