package com.teamzunior.stringcalculator;

import com.teamzunior.stringcalculator.operator.*;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private Pattern pattern = Pattern.compile("(\\ ?-?\\d+)(\\ ?[+|\\-|*|/]\\ ?)(\\ ?-?\\d+)");
    private static Map<String, Operator> operators;

    static {
        operators = new HashMap<>();
        operators.put("+", new PlusOperator());
        operators.put("-", new MinusOperator());
        operators.put("*", new MultiplyOperator());
        operators.put("/", new DivideOperator());
    }

    public int calculate(String input) {
        if(input == null) {
            throw new IllegalArgumentException("Input string is not valid");
        }
        Matcher matcher = pattern.matcher(input);

        if(!matcher.find()) {
            throw new IllegalArgumentException("Input string is not valid");
        }

        String operand = matcher.group(1).trim();
        System.out.println(operand);
        String operatorString = matcher.group(2).trim();
        System.out.println(operatorString);
        String subOperand = matcher.group(3).trim();
        System.out.println(subOperand);

        int parsedOperand = Integer.parseInt(operand);
        int parsedSubOperand = Integer.parseInt(subOperand);

        Operator operator = operators.get(operatorString);

        if(operator == null) {
            throw new IllegalArgumentException("Operator is invalid : [" + operatorString + "]");
        }

        return operator.operate(parsedOperand, parsedSubOperand);
    }
}
