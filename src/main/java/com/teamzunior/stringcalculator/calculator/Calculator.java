package com.teamzunior.stringcalculator.calculator;

import java.math.BigDecimal;
import java.util.Stack;

import static com.teamzunior.stringcalculator.constant.CalculatorConstant.NONE_SPACE;
import static com.teamzunior.stringcalculator.constant.CalculatorConstant.WHITE_SPACE;

/**
 * Created by qkrtjdehd123 on 2020-01-08
 */
public final class Calculator {

    /** 값을 쌓는 단지. **/
    private Stack<BigDecimal> pot = new Stack<>();

    private Calculator(){}

    public Calculator createOfCalculator() {
        return new Calculator();
    }

    public BigDecimal computeStringValue(String line) {

        this.checkLine(line);

        line = line.replaceAll(WHITE_SPACE, NONE_SPACE);

        for(int i = 0; i < line.length(); i++) {

            final char character = line.charAt(i);

        }

        return null;
    }

    private void checkLine(final String line) {
        Validator.checkValidOnInputString(line);
    }
}
