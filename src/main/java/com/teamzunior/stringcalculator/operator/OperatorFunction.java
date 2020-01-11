package com.teamzunior.stringcalculator.operator;

import java.math.BigDecimal;

@FunctionalInterface
public interface OperatorFunction {

    BigDecimal apply(BigDecimal x, BigDecimal y);

}
