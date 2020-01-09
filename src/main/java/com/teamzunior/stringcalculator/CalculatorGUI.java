package com.teamzunior.stringcalculator;

import java.util.Scanner;

public class CalculatorGUI {

    public static final int EXIT_CODE = 1;
    public static final String EXIT_COMMAND = "exit";

    private final Calculator calculator;

    public CalculatorGUI(Calculator calculator) {
        assert calculator != null;

        this.calculator = calculator;
    }

    public int waitInput() {
        final Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("계산식을 입력해주세요.\n");

            final String input = scanner.nextLine();

            if(isExitCommand(input)){
                System.out.println("계산기를 종료합니다");
                return EXIT_CODE;
            }

            double result = calculator.calculate(input);

            System.out.println("결과 : " + result);
        }
    }

    private boolean isExitCommand(String input) {
        return input.equalsIgnoreCase(EXIT_COMMAND);
    }
}
