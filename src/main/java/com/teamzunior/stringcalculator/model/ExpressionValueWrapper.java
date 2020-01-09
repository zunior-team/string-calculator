package com.teamzunior.stringcalculator.model;

public class ExpressionValueWrapper {
    private ExpressionValue expressionValue;

    public ExpressionValueWrapper() {
        expressionValue = null;
    }

    public void change(ExpressionValue to) {
        expressionValue = to;
    }

    public Boolean isEqual(ExpressionValue expressionValue) {
        return this.expressionValue.equals(expressionValue);
    }

    public Boolean isNull() {
        return this.expressionValue == null;
    }
}
