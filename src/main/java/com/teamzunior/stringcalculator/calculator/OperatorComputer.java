package com.teamzunior.stringcalculator.calculator;

import com.teamzunior.stringcalculator.operator.Operator;

import java.math.BigDecimal;
import java.util.Optional;

import static com.teamzunior.stringcalculator.constant.OperatorConstant.*;

/**
 * Created by qkrtjdehd123 on 2020-01-09
 */
public enum OperatorComputer {

    PLUS(PLUS_SYMBOL, (BigDecimal::add)),
    SUBTRACT(SUBTRACT_SYMBOL, (BigDecimal::subtract)),
    DIVIDE(DIVIDE_SYMBOL, (BigDecimal::divide)),
    MULTIPLY(MULTIPLY_SYMBOL, (BigDecimal::multiply));

    private final String symbol;
    private final Operator operator;

    OperatorComputer(final String symbol, final Operator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public Optional<OperatorComputer> findComputerBySymbol(final String element) {

        if (symbol.equalsIgnoreCase(element)) {
            return Optional.of(this);
        }

        return Optional.empty();
    }

    public BigDecimal calculate(final BigDecimal a, final BigDecimal b) {
        return operator.compute(a, b);
    }
}
