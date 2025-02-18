package tr.com.mustafacay.web.exception;

/**
 * Kullanıcı bulunamadığında fırlatılan exception
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
} 