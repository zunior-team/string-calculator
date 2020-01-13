package com.teamzunior.stringcalculator.operator;

import java.math.BigDecimal;

/**
 * Created by qkrtjdehd123 on 2020-01-08
 */
@FunctionalInterface
public interface Operator {

    BigDecimal compute(final BigDecimal a, final BigDecimal b);

}
