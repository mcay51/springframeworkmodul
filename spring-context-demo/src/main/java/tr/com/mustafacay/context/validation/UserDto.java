package tr.com.mustafacay.context.validation;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "Kullanıcı veri transfer nesnesi")
public class UserDto {
    
    @Schema(description = "Kullanıcı adı", example = "Mustafa Çay")
    @NotBlank(message = "İsim boş olamaz")
    private String name;
    
    @Schema(description = "Email adresi", example = "mustafa@example.com")
    @Email(message = "Geçerli bir email adresi giriniz")
    private String email;
    
    @Schema(description = "Yaş", example = "25")
    @Min(value = 18, message = "Yaş en az 18 olmalıdır")
    private int age;
    
    // Getters and Setters
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
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
} 