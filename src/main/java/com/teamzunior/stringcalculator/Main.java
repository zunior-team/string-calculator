package com.teamzunior.stringcalculator;

import com.teamzunior.stringcalculator.calculator.Calculator;

import java.util.Optional;
import java.util.Scanner;

import static com.teamzunior.stringcalculator.ArithmeticConsole.*;

public class Main {

    public static void main(String[] args) {

        printWelcomeMessage();

        while(true){

            final String line = listen();

            if(isExit(line)){
                break;
            }

            Calculator calculator = Calculator.create();
            System.out.println(calculator.computeStringValue(line));
        }

        printByeMessage();
    }
}
