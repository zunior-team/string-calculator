package com.teamzunior.stringcalculator.model;

public class ExpressionValueWrapper {
    private ExpressionValue expressionValue;

    public ExpressionValueWrapper() {
        expressionValue = null;
    }

    public void change(ExpressionValue to) {
        expressionValue = to;
    }

    public ExpressionValue getExpressionValue() {
        return this.expressionValue;
    }
}
