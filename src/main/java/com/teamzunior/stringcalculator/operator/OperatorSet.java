package com.teamzunior.stringcalculator.operator;

import java.util.HashMap;

import static com.teamzunior.stringcalculator.constant.OperatorConstant.*;

/**
 * Created by qkrtjdehd123 on 2020-01-09
 */
public final class OperatorSet {

    // dummy
    private final static HashMap<String, Object> set = new HashMap<String, Object>(){{
        put(PLUS_SYMBOL, new Object());
        put(SUBTRACT_SYMBOL, new Object());
        put(DIVIDE_SYMBOL, new Object());
        put(MULTIPLY_SYMBOL, new Object());
    }};

    public static boolean containsSymbol(final String Symbol) {
        return set.containsKey(Symbol);
    }
}
