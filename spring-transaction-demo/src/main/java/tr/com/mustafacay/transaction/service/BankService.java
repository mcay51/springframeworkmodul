package tr.com.mustafacay.transaction.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import tr.com.mustafacay.transaction.entity.Account;
import tr.com.mustafacay.transaction.exception.InsufficientBalanceException;
import tr.com.mustafacay.transaction.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Banka işlemlerini yöneten servis
 * Farklı transaction senaryoları için örnekler içerir
 */
@Service
public class BankService {
    
    private final AccountRepository accountRepository;
    private final TransactionTemplate transactionTemplate;
    private final TransactionLogService transactionLogService;
    
    public BankService(AccountRepository accountRepository, 
                      TransactionTemplate transactionTemplate,
                      TransactionLogService transactionLogService) {
        this.accountRepository = accountRepository;
        this.transactionTemplate = transactionTemplate;
        this.transactionLogService = transactionLogService;
    }
    
    /**
     * Yüksek izolasyon seviyeli para transferi
     * - SERIALIZABLE: En yüksek izolasyon seviyesi
     * - rollbackFor: Özel exception durumunda rollback
     * - timeout: İşlem zaman aşımı
     */
    @Transactional(
        isolation = Isolation.SERIALIZABLE,
        rollbackFor = InsufficientBalanceException.class,
        timeout = 30
    )
    public void transferWithHighIsolation(String fromAccountNumber, 
                                        String toAccountNumber, 
                                        BigDecimal amount) {
        performTransfer(fromAccountNumber, toAccountNumber, amount);
    }
    
    /**
     * Yeni bir transaction başlatan transfer
     * - REQUIRES_NEW: Her zaman yeni bir transaction başlatır
     * - noRollbackFor: Belirtilen exception'da rollback yapma
     */
    @Transactional(
        propagation = Propagation.REQUIRES_NEW,
        noRollbackFor = RuntimeException.class
    )
    public void transferWithNewTransaction(String fromAccountNumber, 
                                         String toAccountNumber, 
                                         BigDecimal amount) {
        performTransfer(fromAccountNumber, toAccountNumber, amount);
    }
    
    /**
     * Read-only transaction örneği
     * Sadece okuma işlemleri için optimize edilmiş
     */
    @Transactional(readOnly = true)
    public List<Account> getAllAccountsReadOnly() {
        return accountRepository.findAll();
    }
    
    /**
     * Programmatic transaction örneği
     * Manuel transaction kontrolü
     */
    public void transferWithProgrammaticTransaction(String fromAccountNumber, 
                                                  String toAccountNumber, 
                                                  BigDecimal amount) {
        transactionTemplate.execute(status -> {
            try {
                performTransfer(fromAccountNumber, toAccountNumber, amount);
                return null;
            } catch (Exception e) {
                status.setRollbackOnly();
                throw e;
            }
        });
    }
    
    /**
     * Nested transaction örneği
     * İç içe transaction yönetimi
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void transferWithLogging(String fromAccountNumber, 
                                  String toAccountNumber, 
                                  BigDecimal amount) {
        performTransfer(fromAccountNumber, toAccountNumber, amount);
        // Log işlemi ayrı bir transaction'da yapılır
        transactionLogService.logTransfer(fromAccountNumber, toAccountNumber, amount);
    }
    
    private void performTransfer(String fromAccountNumber, 
                               String toAccountNumber, 
                               BigDecimal amount) {
        Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber);
        Account toAccount = accountRepository.findByAccountNumber(toAccountNumber);
        
        if (fromAccount.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException("Yetersiz bakiye");
        }
        
        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));
        
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }
} 