package com.teamzunior.stringcalculator.calculator;

import java.math.BigDecimal;

/**
 * Created by qkrtjdehd123 on 2020-01-08
 */
public final class Calculator {

    /** 값을 쌓는 단지. **/
    private final ValuePot pot = ValuePot.createPot();

    private Calculator(){ }

    public static Calculator createOfCalculator() {
        return new Calculator();
    }

    public BigDecimal computeStringValue(final String line) {

        this.checkLine(line);

        final String[]elements = splitLineByWhiteSpace(line);
        final int size = elements.length;

        for(int i = 0; i < size; i++) {
            pot.compute(elements[i]);
        }

        return pot.getValue();
    }

    /**
     * 유효성 체크
     * @param line  들어온 문자열
     */
    private void checkLine(final String line) {
        Validator.checkValidOnInputString(line);
    }

    /**
     * 공백 기준 문자열 자르기
     * @param line  들어온 문자열
     * @return
     */
    private String[] splitLineByWhiteSpace(final String line) {
        return Splitter.splitByWhiteSpace(line);
    }
}
