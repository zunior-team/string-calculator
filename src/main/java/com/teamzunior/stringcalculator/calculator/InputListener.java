package com.teamzunior.stringcalculator.calculator;

import java.util.Scanner;


public class InputListener {


    private static final String END_SIGN = "q!";
    public static final String BLANK_DELIMITER = " ";
    private Scanner scanner = new Scanner(System.in);


    public void listen() {
        printStartMessage();

        String input = getTrimmedNextLine();

        while (!END_SIGN.equalsIgnoreCase(input)) {
            final String[] tokens = input.split(BLANK_DELIMITER);

            validateElementsCount(tokens);

            final int result = StringCalculator.calculate(tokens);

            System.out.println(result);

            input = getTrimmedNextLine();
        }

        printEndMessage();
    }

    private void printEndMessage() {
        System.out.println("#################        EXIT       #####################");
    }

    private void printStartMessage() {
        System.out.println("################# LISTENING ...     #####################");
        System.out.println("################# PRESS q! to EXIT  #####################");
    }

    private void validateElementsCount(String[] tokens) {
        if (tokens.length < 3) {
            throw new IllegalArgumentException("elements length must lager than 2");
        }
    }

    private String getTrimmedNextLine() {
        return scanner.nextLine()
                .trim();
    }
}
