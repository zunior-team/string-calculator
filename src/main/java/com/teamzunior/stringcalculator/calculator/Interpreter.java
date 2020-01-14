package com.teamzunior.stringcalculator.calculator;

public class Interpreter {

    private Interpreter(){

    }
    public static int interpretNumber(String input) {
        return Integer.parseInt(input);
    }

    public static CalculateType interpretCalculateType(String input) {
        return CalculateType.findBySign(input);
    }
}
