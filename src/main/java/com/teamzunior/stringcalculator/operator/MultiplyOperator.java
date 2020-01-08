package com.teamzunior.stringcalculator.operator;

public class MultiplyOperator implements Operator {
    @Override
    public int operate(int x, int y) {
        return x * y;
    }
}
