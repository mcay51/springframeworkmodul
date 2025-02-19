package tr.com.mustafacay.spel.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;
import tr.com.mustafacay.spel.exception.SpELEvaluationException;
import tr.com.mustafacay.spel.service.SpELEvaluator;

/**
 * SpELEvaluator interface'inin varsayılan implementasyonu.
 */
@Slf4j
@Service
public class SpELEvaluatorImpl implements SpELEvaluator {
    
    private final ExpressionParser parser;
    
    public SpELEvaluatorImpl() {
        this.parser = new SpelExpressionParser();
    }
    
    @Override
    public Object evaluate(String expression) {
        try {
            log.debug("SpEL ifadesi değerlendiriliyor: {}", expression);
            Expression exp = parser.parseExpression(expression);
            Object result = exp.getValue();
            log.debug("Değerlendirme sonucu: {}", result);
            return result;
        } catch (Exception e) {
            log.error("SpEL ifadesi değerlendirilirken hata oluştu: {}", e.getMessage());
            throw new SpELEvaluationException("İfade değerlendirilemedi: " + e.getMessage(), expression);
        }
    }
    
    @Override
    public <T> T evaluate(String expression, Class<T> resultType) {
        try {
            log.debug("SpEL ifadesi {} tipinde değerlendiriliyor: {}", resultType.getSimpleName(), expression);
            Expression exp = parser.parseExpression(expression);
            T result = exp.getValue(resultType);
            log.debug("Değerlendirme sonucu: {}", result);
            return result;
        } catch (Exception e) {
            log.error("SpEL ifadesi değerlendirilirken hata oluştu: {}", e.getMessage());
            throw new SpELEvaluationException("İfade değerlendirilemedi: " + e.getMessage(), expression);
        }
    }
    
    @Override
    public <T> T evaluate(String expression, Object rootObject, Class<T> resultType) {
        try {
            log.debug("SpEL ifadesi {} context'i ile değerlendiriliyor: {}", rootObject, expression);
            Expression exp = parser.parseExpression(expression);
            StandardEvaluationContext context = new StandardEvaluationContext(rootObject);
            T result = exp.getValue(context, resultType);
            log.debug("Değerlendirme sonucu: {}", result);
            return result;
        } catch (Exception e) {
            log.error("SpEL ifadesi değerlendirilirken hata oluştu: {}", e.getMessage());
            throw new SpELEvaluationException("İfade değerlendirilemedi: " + e.getMessage(), expression);
        }
    }
} 