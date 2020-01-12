package com.teamzunior.stringcalculator.model;

import com.teamzunior.stringcalculator.service.Operator;

import java.util.Iterator;
import java.util.List;

public class ExpressionOperators {
    private List<Operator> operators;

    public ExpressionOperators(List<Operator> operators) {
        this.operators = operators;
    }

    public Iterator<Operator> iterator() {
        return operators.iterator();
    }
}
