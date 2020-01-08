package com.teamzunior.stringcalculator;

import java.util.Objects;

import static com.teamzunior.stringcalculator.Operator.PLUS;

public class Formula {
    private Formula formula;
    private Operator operator;
    private Integer operand;

    public Formula() {}

    public Formula(Integer operand, Operator operator, String formulaString) {
        this.operand = operand;
        this.operator = operator;
        this.formula = Interpreter.interpret(formulaString);
    }

    /**
     * constructor for number only formula
     * @param operand
     */
    public Formula(Integer operand) {
        this.operand = operand;
        this.operator = PLUS;
        this.formula = new Formula() {
            public Integer calculate() {
                return 0;
            }
        };
    }

    public Integer calculate() {
        return operator.operate(formula.calculate(), operand);
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
