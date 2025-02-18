package tr.com.mustafacay.transaction.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tr.com.mustafacay.transaction.entity.Account;
import tr.com.mustafacay.transaction.entity.TransactionLog;
import tr.com.mustafacay.transaction.repository.AccountRepository;
import tr.com.mustafacay.transaction.repository.TransactionLogRepository;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class BankServiceTest {
    
    @Autowired
    private BankService bankService;
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private TransactionLogRepository transactionLogRepository;
    
    @Test
    void whenTransferWithSufficientBalance_thenSuccess() {
        // Given
        Account fromAccount = new Account();
        fromAccount.setAccountNumber("123");
        fromAccount.setBalance(new BigDecimal("1000"));
        accountRepository.save(fromAccount);
        
        Account toAccount = new Account();
        toAccount.setAccountNumber("456");
        toAccount.setBalance(new BigDecimal("0"));
        accountRepository.save(toAccount);
        
        // When
        bankService.transfer("123", "456", new BigDecimal("500"));
        
        // Then
        Account updatedFromAccount = accountRepository.findByAccountNumber("123");
        Account updatedToAccount = accountRepository.findByAccountNumber("456");
        
        assertEquals(new BigDecimal("500"), updatedFromAccount.getBalance());
        assertEquals(new BigDecimal("500"), updatedToAccount.getBalance());
    }
    
    @Test
    void whenTransferWithInsufficientBalance_thenThrowException() {
        // Given
        Account fromAccount = new Account();
        fromAccount.setAccountNumber("789");
        fromAccount.setBalance(new BigDecimal("100"));
        accountRepository.save(fromAccount);
        
        Account toAccount = new Account();
        toAccount.setAccountNumber("012");
        toAccount.setBalance(new BigDecimal("0"));
        accountRepository.save(toAccount);
        
        // When & Then
        assertThrows(RuntimeException.class, () -> 
            bankService.transfer("789", "012", new BigDecimal("500")));
    }
    
    @Test
    void whenTransferWithHighIsolation_thenSuccess() {
        // Test implementation
    }
    
    @Test
    void whenTransferWithNewTransaction_thenSuccess() {
        // Test implementation
    }
    
    @Test
    void whenTransferWithLogging_thenBothOperationsSucceed() {
        // Given
        Account fromAccount = createAccount("123", "1000");
        Account toAccount = createAccount("456", "0");
        
        // When
        bankService.transferWithLogging("123", "456", new BigDecimal("500"));
        
        // Then
        Account updatedFromAccount = accountRepository.findByAccountNumber("123");
        Account updatedToAccount = accountRepository.findByAccountNumber("456");
        
        assertEquals(new BigDecimal("500"), updatedFromAccount.getBalance());
        assertEquals(new BigDecimal("500"), updatedToAccount.getBalance());
        
        // Verify log
        TransactionLog log = transactionLogRepository.findFirstByOrderByTransactionDateDesc();
        assertNotNull(log);
        assertEquals("123", log.getFromAccount());
        assertEquals("456", log.getToAccount());
        assertEquals(new BigDecimal("500"), log.getAmount());
    }
    
    private Account createAccount(String accountNumber, String balance) {
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setBalance(new BigDecimal(balance));
        return accountRepository.save(account);
    }
} 