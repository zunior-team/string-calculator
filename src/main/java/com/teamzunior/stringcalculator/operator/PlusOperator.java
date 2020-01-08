package com.teamzunior.stringcalculator.operator;

public class PlusOperator implements Operator {
    @Override
    public int operate(int x, int y) {
        return x + y;
    }
}
