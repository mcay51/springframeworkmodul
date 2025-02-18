package tr.com.mustafacay.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.mustafacay.transaction.entity.Account;

/**
 * Account entity'si için repository
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountNumber(String accountNumber);
} 