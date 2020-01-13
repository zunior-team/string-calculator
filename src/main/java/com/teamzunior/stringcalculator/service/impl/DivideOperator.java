package com.teamzunior.stringcalculator.service.impl;

import com.teamzunior.stringcalculator.service.Operator;

public class DivideOperator implements Operator {

    @Override
    public Integer operate(Integer first, Integer second) {
        return first / second;
    }
}
