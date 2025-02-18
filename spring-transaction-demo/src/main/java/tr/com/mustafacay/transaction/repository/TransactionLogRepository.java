package tr.com.mustafacay.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.mustafacay.transaction.entity.TransactionLog;

/**
 * TransactionLog entity'si için repository
 */
public interface TransactionLogRepository extends JpaRepository<TransactionLog, Long> {
    
    /**
     * En son yapılan transaction log kaydını getirir
     */
    TransactionLog findFirstByOrderByTransactionDateDesc();
} 