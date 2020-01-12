package com.teamzunior.stringcalculator.operator;

import java.util.HashMap;
import java.util.Optional;

import static com.teamzunior.stringcalculator.constant.OperatorConstant.*;

/**
 * Created by qkrtjdehd123 on 2020-01-09
 */
public final class OperatorSet {

    private final static HashMap<String, OperatorComputer> set = new HashMap<String, OperatorComputer>(){{
        put(PLUS_SYMBOL, OperatorComputer.PLUS);
        put(SUBTRACT_SYMBOL, OperatorComputer.SUBTRACT);
        put(DIVIDE_SYMBOL, OperatorComputer.DIVIDE);
        put(MULTIPLY_SYMBOL, OperatorComputer.MULTIPLY);
    }};

    public static boolean containsSymbol(final String Symbol) {
        return set.containsKey(Symbol);
    }

    public static Optional<OperatorComputer> findComputerBySymbol(final String symbol) {

        if(set.get(symbol) == null){
            return Optional.empty();
        }

        return Optional.of(set.get(symbol));
    }
}
