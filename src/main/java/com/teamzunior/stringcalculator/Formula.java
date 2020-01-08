package com.teamzunior.stringcalculator;

import java.util.Objects;

public class Formula {
    private String formulaString;
    private int operand;
    private String operator;
    private Formula formula;

    public Formula() {
    }

    public Formula(int operand, String operator, String formulaString) {
        this.operand = operand;
        this.operator = operator;
        this.formula = new Formula(formulaString);
    }

    public Formula(String formulaString) {
        this.formulaString = formulaString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formula formula1 = (Formula) o;
        return operand == formula1.operand &&
                Objects.equals(formulaString, formula1.formulaString) &&
                Objects.equals(operator, formula1.operator) &&
                Objects.equals(formula, formula1.formula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formulaString, operand, operator, formula);
    }
}
