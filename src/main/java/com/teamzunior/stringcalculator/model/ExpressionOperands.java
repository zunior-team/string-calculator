package com.teamzunior.stringcalculator.model;

import java.util.Iterator;
import java.util.List;

public class ExpressionOperands {
    private List<Integer> operands;

    public ExpressionOperands(List<Integer> operands) {
        this.operands = operands;
    }

    public Iterator<Integer> iterator() {
        return operands.iterator();
    }
}
