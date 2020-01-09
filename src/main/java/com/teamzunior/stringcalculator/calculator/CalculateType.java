package com.teamzunior.stringcalculator.calculator;

import org.springframework.util.Assert;

import java.util.Arrays;

import static com.teamzunior.stringcalculator.calculator.StringCalculator.*;

public enum CalculateType {

    SUM(SUM_SIGN), SUB(SUB_SIGN), MULTI(MULTI_SIGN), DIV(DIV_SIGN);

    private String sign;

    CalculateType(String sign) {
        this.sign = sign;
    }

    public static CalculateType findBySign(String sign) {
        Assert.notNull(sign, "sign must not be null");
        return Arrays.stream(values())
                .filter(calculateType -> calculateType.hasSign(sign))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean hasSign(String param) {
        return sign.equalsIgnoreCase(param);
    }
}