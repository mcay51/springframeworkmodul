package tr.com.mustafacay.transaction.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Transaction log kayıtları için entity
 */
@Entity
@Table(name = "transaction_logs")
public class TransactionLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String fromAccount;
    
    @Column(nullable = false)
    private String toAccount;
    
    @Column(nullable = false)
    private BigDecimal amount;
    
    @Column(nullable = false)
    private LocalDateTime transactionDate;
    
    // Getters and Setters
    // ... (getter ve setter metodları)
} 