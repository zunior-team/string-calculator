package com.teamzunior.stringcalculator;

import java.util.function.BiFunction;

public enum Operator {
    PLUS(Math::addExact),
    MINUS(Math::subtractExact),
    MULTIPLY(Math::multiplyExact),
    DIVIDE(Math::floorDiv);

    private BiFunction<Integer, Integer, Integer> function;

    Operator(BiFunction<Integer, Integer, Integer> function) {
        this.function = function;
    }

    public Integer operate(Integer x, Integer y) {
        return function.apply(x, y);
    }
}
