package tr.com.mustafacay.transaction.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tr.com.mustafacay.transaction.entity.TransactionLog;
import tr.com.mustafacay.transaction.repository.TransactionLogRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Transaction log işlemlerini yöneten servis
 */
@Service
public class TransactionLogService {
    
    private final TransactionLogRepository transactionLogRepository;
    
    public TransactionLogService(TransactionLogRepository transactionLogRepository) {
        this.transactionLogRepository = transactionLogRepository;
    }
    
    /**
     * Transfer işlemini loglar
     * REQUIRES_NEW kullanarak ana transaction'dan bağımsız çalışır
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void logTransfer(String fromAccount, String toAccount, BigDecimal amount) {
        TransactionLog log = new TransactionLog();
        log.setFromAccount(fromAccount);
        log.setToAccount(toAccount);
        log.setAmount(amount);
        log.setTransactionDate(LocalDateTime.now());
        
        transactionLogRepository.save(log);
    }
} 