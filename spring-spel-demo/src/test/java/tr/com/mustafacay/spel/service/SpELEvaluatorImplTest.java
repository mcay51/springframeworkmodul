package tr.com.mustafacay.spel.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tr.com.mustafacay.spel.entity.Person;
import tr.com.mustafacay.spel.exception.SpELEvaluationException;
import tr.com.mustafacay.spel.service.impl.SpELEvaluatorImpl;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SpELEvaluatorImplTest {

    private SpELEvaluator spelEvaluator;

    @BeforeEach
    void setUp() {
        spelEvaluator = new SpELEvaluatorImpl();
    }

    @Test
    void testEvaluateArithmeticExpression() {
        String expression = "2 + 3 * 4";
        Integer result = spelEvaluator.evaluate(expression, Integer.class);
        assertEquals(14, result);
    }

    @Test
    void testEvaluateStringExpression() {
        String expression = "'hello'.toUpperCase()";
        String result = spelEvaluator.evaluate(expression, String.class);
        assertEquals("HELLO", result);
    }

    @Test
    void testEvaluateWithRootObject() {
        Person person = new Person();
        person.setName("Ahmet");
        person.setSurname("Yılmaz");
        person.setBirthDate(LocalDate.of(1990, 1, 1));

        String expression = "name + ' ' + surname";
        String result = spelEvaluator.evaluate(expression, person, String.class);
        assertEquals("Ahmet Yılmaz", result);
    }

    @Test
    void testEvaluateInvalidExpression() {
        String expression = "invalid + expression";
        assertThrows(SpELEvaluationException.class, () -> 
            spelEvaluator.evaluate(expression)
        );
    }
} 