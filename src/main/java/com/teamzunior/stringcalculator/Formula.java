package com.teamzunior.stringcalculator;

import java.util.Objects;

public class Formula implements Expression {
    private Expression formula;
    private Operator operator;
    private Integer operand;

    public Formula(Integer operand, Operator operator, Expression subFormula) {
        this.formula = subFormula;
        this.operator = operator;
        this.operand = operand;
    }

    public Integer calculate() {
        return operator.operate(formula.calculate(), operand);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formula formula1 = (Formula) o;
        return Objects.equals(formula, formula1.formula) &&
                operator == formula1.operator &&
                Objects.equals(operand, formula1.operand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formula, operator, operand);
    }
}
