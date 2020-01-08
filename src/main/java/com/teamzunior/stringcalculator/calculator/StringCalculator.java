package com.teamzunior.stringcalculator.calculator;

public class StringCalculator {
    public static final String SUM_SIGN = "+";
    public static final String SUB_SIGN = "-";
    public static final String DIV_SIGN = "/";
    public static final String MULTI_SIGN = "*";

    public static int calculate(String[] elements) {
        return new StringCalculatorElements(elements).calculateAll();
    }
}
