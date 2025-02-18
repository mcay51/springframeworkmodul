package tr.com.mustafacay.transaction.exception;

public class AccountNotFoundException extends RuntimeException {
    
    public AccountNotFoundException(String accountNumber) {
        super("Hesap bulunamadı: " + accountNumber);
    }
} 