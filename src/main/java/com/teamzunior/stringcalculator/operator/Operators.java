package com.teamzunior.stringcalculator.operator;

import java.util.HashMap;
import java.util.Map;

public class Operators {

    private final static String PLUS_OPERATOR  = "+";
    private final static String MINUS_OPERATOR  = "-";
    private final static String MULTI_OPERATOR  = "*";
    private final static String MOD_OPERATOR  = "/";

    private final Map<String, OperatorFunction> operateMap;

    public Operators() {
        this.operateMap = new HashMap<>();
        this.operateMap.put(PLUS_OPERATOR, (a, b) -> (a + b));
        this.operateMap.put(MINUS_OPERATOR, (a, b) -> (a - b));
        this.operateMap.put(MULTI_OPERATOR, (a, b) -> (a * b));
        this.operateMap.put(MOD_OPERATOR, (a, b) -> (a / b));
    }

    public void registerOperator(String operator, OperatorFunction operatorFunction) {
        this.operateMap.put(operator, operatorFunction);
    }

    public String parse(String operator) {
        validate(operator);
        return operator;
    }

    public double apply(String operator, double a, double b) {
        validate(operator);
        return operateMap.get(operator).apply(a, b);
    }

    private void validate(String operator) {
        if (!operateMap.containsKey(operator)) {
            throw new RuntimeException("죄송합니다, 알 수 없는 연산자 입니다 : " + operator);
        }
    }

}
