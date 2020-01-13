package com.teamzunior.stringcalculator;

import java.util.Objects;

public class Number implements Expression {
    private Integer number;

    Number(String number) {
        try {
            this.number = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Is not number : " + number);
        }
    }

    @Override
    public Integer calculate() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return Objects.equals(number, number1.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
