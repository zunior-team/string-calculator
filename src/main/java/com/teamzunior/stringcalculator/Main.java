package com.teamzunior.stringcalculator;

import java.util.Scanner;

public class Main {
    private static final String EXIT = "exit";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("수식을 입력해주세요(종료를 원하실경우 exit) : ");
            String input = scanner.nextLine();

            if(EXIT.equalsIgnoreCase(input)) {
                return;
            }

            System.out.println("계산 결과는 : " + Calculator.calculate(input));
        }

    }
}
