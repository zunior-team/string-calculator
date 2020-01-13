package com.teamzunior.stringcalculator;

import java.util.Scanner;

public class ArithmeticConsole {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String EXIT = "exit";

    static void printWelcomeMessage() {
        System.out.println("========== 산술연산의 세계에 오신것을 환영합니다. ==========");
        System.out.println("[\"+\", \"-\", \"*\", \"/\"] 네가지 기호 사용이 가능합니다.");
        System.out.println("ex 1 ) 2 + 5 / 10 * 2");
        System.out.println("ex 2 ) 10 * 5 / 10 / 2");
        System.out.println("- 종료하고 싶은 경우 exit 를 입력해주세요.");
        System.out.println("====================================================");
    }

    static String listen(){
        return SCANNER.nextLine();
    }

    static boolean isExit(final String exitMessage) {
        return (EXIT.equalsIgnoreCase(exitMessage));
    }

    static void printByeMessage() {
        System.out.println("====================================================");
        System.out.println("==========           안녕히 가세요.          ==========");
        System.out.println("====================================================");
    }

}
