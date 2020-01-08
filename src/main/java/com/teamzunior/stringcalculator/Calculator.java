package com.teamzunior.stringcalculator;

public class Calculator {
    public static int calculate(String input) {
        return Interpreter.interpret(input)
                .calculate();
    }
}
