package com.teamzunior.stringcalculator;

import com.teamzunior.stringcalculator.operator.Operators;

import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        final Operators operators = new Operators();
        final Calculator calculator = new Calculator(operators);

        final int code = new CalculatorGUI(calculator).waitInput();

        System.exit(code);
    }
}
