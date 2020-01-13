package com.teamzunior.stringcalculator.model;

public enum ExpressionValue {
    NUMBER, OPERATOR;

    public boolean isNumber() {
        return this.equals(ExpressionValue.NUMBER);
    }

    public boolean isOperator() {
        return this.equals(ExpressionValue.OPERATOR);
    }
}
