package com.teamzunior.stringcalculator.calculator;

import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {

    private static Map<CalculateType, BiFunction<Integer, Integer, Integer>> calculateMap = new HashMap<>();

    static {
        calculateMap.put(CalculateType.SUM, Math::addExact);
        calculateMap.put(CalculateType.SUB, Math::subtractExact);
        calculateMap.put(CalculateType.MULTI, Math::multiplyExact);
        calculateMap.put(CalculateType.DIV, Math::floorDiv);
    }

    private Calculator() {
    }

    public static int calculate(int a, int b, CalculateType calculateType) {
        Assert.notNull(calculateType, "calculateType must not be null");

        return calculateMap.get(calculateType)
                .apply(a, b);
    }
}
