package tr.com.mustafacay.spel.service;

public interface SpELEvaluator{

    public Object evaluate(String expression);
    public <T> T evaluate(String expression, Class<T> resultType);
    public <T> T evaluate(String expression, Object rootObject, Class<T> resultType);



}