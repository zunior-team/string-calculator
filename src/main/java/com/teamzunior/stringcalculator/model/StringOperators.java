package com.teamzunior.stringcalculator.model;

import com.teamzunior.stringcalculator.service.Operator;
import com.teamzunior.stringcalculator.service.impl.DivideOperator;
import com.teamzunior.stringcalculator.service.impl.MinusOperator;
import com.teamzunior.stringcalculator.service.impl.MultiplyOperator;
import com.teamzunior.stringcalculator.service.impl.PlusOperator;

import java.util.HashMap;
import java.util.Map;

public class StringOperators {
    private Map<String, Operator> operators = new HashMap<>();

    private static final String PLUS_SIGN = "+";
    private static final String MINUS_SIGN = "-";
    private static final String MULTIPLY_SIGN = "*";
    private static final String DIVIDE_SIGN = "/";

    public StringOperators() {
        operators.put(PLUS_SIGN, new PlusOperator());
        operators.put(MINUS_SIGN, new MinusOperator());
        operators.put(MULTIPLY_SIGN, new MultiplyOperator());
        operators.put(DIVIDE_SIGN, new DivideOperator());
    }

    public Operator get(String sign) {
        if (!operators.containsKey(sign)) {
            throw new RuntimeException(sign + " is not acceptable.");
        }
        return operators.get(sign);
    }
}
