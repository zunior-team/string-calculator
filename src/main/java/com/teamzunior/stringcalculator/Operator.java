package com.teamzunior.stringcalculator;

import java.util.function.BiFunction;

public enum Operator {
    PLUS((x, y) -> x + y),
    MINUS((x, y) -> x - y),
    MULTIPLY((x, y) -> x * y),
    DIVIDE((x, y) -> x / y);

    private BiFunction<Integer, Integer, Integer> function;

    Operator(BiFunction<Integer, Integer, Integer> function) {
        this.function = function;
    }

    public Integer operate(Integer x, Integer y) {
        return function.apply(x, y);
    }
}
