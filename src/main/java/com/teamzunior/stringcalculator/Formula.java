package com.teamzunior.stringcalculator;

import java.util.Objects;

public class Formula implements Expression {
    private Integer operand;
    private Operator operator;
    private Expression formula;

    public Formula(Integer operand, Operator operator, String formulaString) {
        this.operand = operand;
        this.operator = operator;
        this.formula = Interpreter.interpret(formulaString);
    }

    public Formula(Integer operand, Operator operator) {
        this.operand = operand;
        this.operator = operator;
        this.formula = () -> 0;
    }

    @Override
    public Integer calculate() {
        return operator.operate(operand, formula.calculate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formula formula1 = (Formula) o;
        return operand == formula1.operand &&
                Objects.equals(operator, formula1.operator) &&
                Objects.equals(formula, formula1.formula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand, operator, formula);
    }
}
