package com.teamzunior.stringcalculator.service.impl;

import com.teamzunior.stringcalculator.service.StringOperator;

public class PlusStringOperator implements StringOperator {
    @Override
    public Integer operate(String a, String b) {
        return Integer.parseInt(a) + Integer.parseInt(b);
    }
}
