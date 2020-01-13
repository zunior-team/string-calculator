package com.teamzunior.stringcalculator;

import java.util.HashMap;
import java.util.Map;

import static com.teamzunior.stringcalculator.Operator.*;
import static com.teamzunior.stringcalculator.Operator.DIVIDE;

public class Operators {
    private static final Map<String, Operator> operators;

    static {
        operators = new HashMap<>();
        operators.put("+", PLUS);
        operators.put("-", MINUS);
        operators.put("*", MULTIPLY);
        operators.put("/", DIVIDE);
    }

    public static Operator convert(String operatorString) {
        return operators.get(operatorString);
    }
}
