package com.teamzunior.stringcalculator.operator;

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

    public BigDecimal calculate(final BigDecimal x, final BigDecimal y) {
        return operator.compute(x, y);
    }
}
