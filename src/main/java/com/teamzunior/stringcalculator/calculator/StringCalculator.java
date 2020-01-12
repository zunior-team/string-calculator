package com.teamzunior.stringcalculator.calculator;

public class StringCalculator {
    public static final String SUM_SIGN = "+";
    public static final String SUB_SIGN = "-";
    public static final String DIV_SIGN = "/";
    public static final String MULTI_SIGN = "*";
    public static final int MINIMUM_EXPRESSION_LENGTH = 3;
    public static final int EXPRESSION_INTERVAL = 2;


    public static int calculate(String[] elements) {
        validateElements(elements);

        int result = initFirstOperand(elements);
        for (int index = 1; index < elements.length; index += EXPRESSION_INTERVAL) {
            final CalculateType calculateType = Interpreter.interpretCalculateType(elements[index]);
            final int calculateNumber = Interpreter.interpretNumber(elements[index + 1]);

            result = Expression.newInstance(result, calculateNumber, calculateType)
                    .result();
        }
        return result;
    }

    private static int initFirstOperand(String[] elements) {
        return Interpreter.interpretNumber(elements[0]);
    }

    private static void validateElements(String[] elements) {
        if (elements.length < MINIMUM_EXPRESSION_LENGTH) {
            throw new IllegalArgumentException("elements length must lager than 2");
        }
    }
}
