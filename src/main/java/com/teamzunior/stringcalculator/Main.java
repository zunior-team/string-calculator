package com.teamzunior.stringcalculator;

import com.teamzunior.stringcalculator.service.StringCalculator;
import com.teamzunior.stringcalculator.service.impl.StringCalculatorUsingPolymorphism;

import static com.teamzunior.stringcalculator.view.InputView.inputLine;

public class Main {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculatorUsingPolymorphism();
        String expression = inputLine();

        System.out.println(calculator.calculate(expression));
    }
}
