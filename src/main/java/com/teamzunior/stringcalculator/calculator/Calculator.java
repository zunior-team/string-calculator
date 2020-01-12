package com.teamzunior.stringcalculator.calculator;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.stream.Stream;

/**
 * Created by qkrtjdehd123 on 2020-01-08
 */
public final class Calculator {

    private final CalculatorAnswerPotAdapter potAdapter;

    private Calculator(){
        this.potAdapter = new CalculatorAnswerPotAdapter();
    }

    public static Calculator create() {
        return new Calculator();
    }

    public BigDecimal computeStringValue(final String line) {

        this.checkIsNullOrEmpty(line);

        return potAdapter.compute(splitLineByWhiteSpace(line));
    }

    private void checkIsNullOrEmpty(final String line) {

        if(StringUtils.isEmpty(line)) {
            throw new IllegalArgumentException("입력 값이 널 또는 빈 공백 문자열입니다.");
        }
    }

    private Stream<String> splitLineByWhiteSpace(final String line) {
        return Splitter.splitByWhiteSpace(line);
    }
}
