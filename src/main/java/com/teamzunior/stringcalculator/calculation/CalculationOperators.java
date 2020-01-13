package com.teamzunior.stringcalculator.calculation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CalculationOperators {


    private final List<String> operators;

    public CalculationOperators(List<String> operators) {
        assert operators != null;

        this.operators= new ArrayList<>(operators);
    }

    public int size() {
        return operators.size();
    }

    public Iterator<String> iterator() {
        return this.operators.iterator();
    }
}
