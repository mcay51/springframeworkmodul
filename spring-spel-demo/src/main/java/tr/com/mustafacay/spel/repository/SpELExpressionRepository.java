package tr.com.mustafacay.spel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.mustafacay.spel.entity.SpELExpression;

public interface SpELExpressionRepository extends JpaRepository<SpELExpression, Long> {
    // İleride gerekebilecek özel sorgular buraya eklenebilir
} 