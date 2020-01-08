package com.teamzunior.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private Pattern pattern = Pattern.compile("(\\ ?-?\\d)(\\ ?[+|\\-|*|/]\\ ?)(\\ ?-?\\d)");

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
        String operator = matcher.group(2).trim();
        System.out.println(operator);
        String subOperand = matcher.group(3).trim();
        System.out.println(subOperand);

        int parsedOperand = Integer.parseInt(operand);
        int parsedSubOperand = Integer.parseInt(subOperand);

        switch (operator) {
            case "+":
                return parsedOperand + parsedSubOperand;

            case "-":
                return parsedOperand - parsedSubOperand;

            case "*":
                return parsedOperand * parsedSubOperand;

            case "/":
                return parsedOperand / parsedSubOperand;

            default:
                throw new IllegalArgumentException("Unknown operator : " + operator);
        }
    }
}
