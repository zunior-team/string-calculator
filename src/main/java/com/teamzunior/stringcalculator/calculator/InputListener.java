package com.teamzunior.stringcalculator.calculator;

import java.util.Scanner;


public class InputListener {


    private static final String END_SIGN = "q!";
    public static final String BLANK_DELIMITER = " ";
    private Scanner scanner = new Scanner(System.in);


    public void listen() {
        System.out.println("################# LISTENING ...     #####################");
        System.out.println("################# PRESS q! to EXIT  #####################");

        String input = scanner.nextLine()
                .trim();
        while (!END_SIGN.equalsIgnoreCase(input)) {

            final int result = StringCalculator.calculate(input.split(BLANK_DELIMITER));
            System.out.println(result);


            input = scanner.nextLine()
                    .trim();
        }

        System.out.println("#################        EXIT       #####################");
    }
}
