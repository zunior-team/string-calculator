package com.teamzunior.stringcalculator.operator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Operators {

    private final static String PLUS_OPERATOR = "+";
    private final static String MINUS_OPERATOR = "-";
    private final static String MULTI_OPERATOR = "*";
    private final static String MOD_OPERATOR = "/";

    private final Map<String, OperatorFunction> operateMap;

    public Operators() {
        this.operateMap = new HashMap<>();
        initBasicOperators();
    }

    private void initBasicOperators() {
        this.operateMap.put(PLUS_OPERATOR, Double::sum);
        this.operateMap.put(MINUS_OPERATOR, (x, y) -> Double.sum(x, y * -1));
        this.operateMap.put(MULTI_OPERATOR, (x, y) -> (x * y));
        this.operateMap.put(MOD_OPERATOR, (x, y) -> (x / y));
    }

    public void registerOperator(String operator, OperatorFunction operatorFunction) {
        this.operateMap.put(operator, operatorFunction);
    }

    public String parse(String operator) {
        validate(operator);
        return operator;
    }

    public double apply(String operator, double x, double y) {
        validate(operator);
        return operateMap.get(operator).apply(x, y);
    }

    private void validate(String operator) {
        if (!operateMap.containsKey(operator)) {
            throw new RuntimeException("죄송합니다, 알 수 없는 연산자 입니다 : " + operator);
        }
    }

}
