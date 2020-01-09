package com.teamzunior.stringcalculator;

import com.teamzunior.stringcalculator.calculator.Calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        final String line = scanner.nextLine();

        Calculator calculator = Calculator.createOfCalculator();
        System.out.println(calculator.computeStringValue(line));
    }
}
