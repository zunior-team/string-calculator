package com.teamzunior.stringcalculator.calculator;

public class Expression {
    private int first;
    private int second;
    private CalculateType calculateType;
    private boolean isCalculated;
    private int result;

    private Expression(int first, int second, CalculateType calculateType) {
        this.first = first;
        this.second = second;
        this.calculateType = calculateType;
    }

    public static Expression newInstance(int first, int second, CalculateType calculateType) {
        return new Expression(first, second, calculateType);
    }

    public int result() {
        if (isCalculated) {
            return result;
        }

        final int result = Calculator.calculate(first, second, calculateType);
        this.result = result;
        isCalculated = true;

        return result;
    }
}
