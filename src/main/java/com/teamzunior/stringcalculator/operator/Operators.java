package com.teamzunior.stringcalculator.operator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Operators {

    private final static String PLUS_OPERATOR = "+";
    private final static String MINUS_OPERATOR = "-";
    private final static String MULTI_OPERATOR = "*";
    private final static String MOD_OPERATOR = "/";

    private final Map<String, OperatorFunction> operators;

    {
        this.operators = new HashMap<>();
        operators.put(PLUS_OPERATOR, BigDecimal::add);
        operators.put(MINUS_OPERATOR, BigDecimal::subtract);
        operators.put(MULTI_OPERATOR, BigDecimal::multiply);
        operators.put(MOD_OPERATOR, BigDecimal::divide);
    }

    public void registerOperator(String operator, OperatorFunction operatorFunction) {
        this.operators.put(operator, operatorFunction);
    }

    public String parse(String operator) {
        validate(operator);
        return operator;
    }

    public BigDecimal apply(String operator, BigDecimal x, BigDecimal y) {
        validate(operator);
        return operators.get(operator).apply(x, y);
    }

    private void validate(String operator) {
        if (!operators.containsKey(operator)) {
            throw new RuntimeException("죄송합니다, 알 수 없는 연산자 입니다 : " + operator);
        }
    }

}
