package com.teamzunior.stringcalculator;

import com.teamzunior.stringcalculator.operator.Operators;

public class Main {

    public static void main(String[] args) {
        final Operators operators = new Operators();
        final Calculator calculator = new Calculator(operators);

        final int code = new CalculatorBoard(calculator).waitInput();

        System.exit(code);
    }
}
