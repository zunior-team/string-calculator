package com.teamzunior.stringcalculator.calculation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CalculationNumbers {

    private final List<BigDecimal> numbers;

    public CalculationNumbers(List<BigDecimal> numbers) {
        assert numbers != null;

        this.numbers = new ArrayList<>(numbers);
    }

    public int size() {
        return this.numbers.size();
    }

    public BigDecimal getByIndex(int i) {
        return this.numbers.get(i);
    }
}
