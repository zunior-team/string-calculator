package com.teamzunior.stringcalculator.calculator;

import java.util.Arrays;

import static com.teamzunior.stringcalculator.calculator.StringCalculator.*;

public enum CalculateType {

    SUM(SUM_SIGN), SUB(SUB_SIGN), MULTI(MULTI_SIGN), DIV(DIV_SIGN);

    private String sign;

    CalculateType(String sign) {
        this.sign = sign;
    }

    public static CalculateType findBySign(String sign) {
        return Arrays.stream(values())
                .filter(calculateType -> calculateType.hasSign(sign))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean hasSign(String sign) {
        return this.sign.equalsIgnoreCase(sign);
    }
}