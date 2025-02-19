package tr.com.mustafacay.spel.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "spel_expressions")
public class SpELExpression {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String expression;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "last_evaluated")
    private LocalDateTime lastEvaluated;
    
    @Column(name = "evaluation_count")
    private Long evaluationCount;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        evaluationCount = 0L;
    }
} 