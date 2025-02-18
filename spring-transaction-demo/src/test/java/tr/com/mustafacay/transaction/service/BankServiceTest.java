package tr.com.mustafacay.transaction.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tr.com.mustafacay.transaction.entity.Account;
import tr.com.mustafacay.transaction.entity.TransactionLog;
import tr.com.mustafacay.transaction.exception.InsufficientBalanceException;
import tr.com.mustafacay.transaction.repository.AccountRepository;
import tr.com.mustafacay.transaction.repository.TransactionLogRepository;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

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
        Account fromAccount = createAccount("123", "1000");
        Account toAccount = createAccount("456", "0");
        
        // When
        bankService.transferWithHighIsolation("123", "456", new BigDecimal("500"));
        
        // Then
        Account updatedFromAccount = accountRepository.findByAccountNumber("123");
        Account updatedToAccount = accountRepository.findByAccountNumber("456");
        
        assertEquals(new BigDecimal("500"), updatedFromAccount.getBalance());
        assertEquals(new BigDecimal("500"), updatedToAccount.getBalance());
    }
    
    @Test
    void whenTransferWithInsufficientBalance_thenThrowException() {
        // Given
        Account fromAccount = createAccount("789", "100");
        Account toAccount = createAccount("012", "0");
        
        // When & Then
        assertThrows(InsufficientBalanceException.class, () -> 
            bankService.transferWithHighIsolation("789", "012", new BigDecimal("500")));
    }
    
    @Test
    void whenTransferWithHighIsolation_thenSuccess() {
        // Given
        Account fromAccount = createAccount("111", "1000");
        Account toAccount = createAccount("222", "0");
        
        // When
        bankService.transferWithHighIsolation("111", "222", new BigDecimal("300"));
        
        // Then
        Account updatedFromAccount = accountRepository.findByAccountNumber("111");
        Account updatedToAccount = accountRepository.findByAccountNumber("222");
        
        assertEquals(new BigDecimal("700"), updatedFromAccount.getBalance());
        assertEquals(new BigDecimal("300"), updatedToAccount.getBalance());
    }
    
    @Test
    void whenTransferWithNewTransaction_thenSuccess() {
        // Given
        Account fromAccount = createAccount("333", "1000");
        Account toAccount = createAccount("444", "0");
        
        // When
        bankService.transferWithNewTransaction("333", "444", new BigDecimal("400"));
        
        // Then
        Account updatedFromAccount = accountRepository.findByAccountNumber("333");
        Account updatedToAccount = accountRepository.findByAccountNumber("444");
        
        assertEquals(new BigDecimal("600"), updatedFromAccount.getBalance());
        assertEquals(new BigDecimal("400"), updatedToAccount.getBalance());
    }
    
    @Test
    void whenTransferWithLogging_thenBothOperationsSucceed() {
        // Given
        Account fromAccount = createAccount("555", "1000");
        Account toAccount = createAccount("666", "0");
        
        // When
        bankService.transferWithLogging("555", "666", new BigDecimal("500"));
        
        // Then
        Account updatedFromAccount = accountRepository.findByAccountNumber("555");
        Account updatedToAccount = accountRepository.findByAccountNumber("666");
        
        assertEquals(new BigDecimal("500"), updatedFromAccount.getBalance());
        assertEquals(new BigDecimal("500"), updatedToAccount.getBalance());
        
        // Verify log
        TransactionLog log = transactionLogRepository.findFirstByOrderByTransactionDateDesc();
        assertNotNull(log);
        assertEquals("555", log.getFromAccount());
        assertEquals("666", log.getToAccount());
        assertEquals(new BigDecimal("500"), log.getAmount());
    }
    
    private Account createAccount(String accountNumber, String balance) {
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setBalance(new BigDecimal(balance));
        return accountRepository.save(account);
    }
} 