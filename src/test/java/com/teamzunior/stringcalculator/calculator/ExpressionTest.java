package com.teamzunior.stringcalculator.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionTest {

    @Test
    @DisplayName("식 생성 테스트")
    void testCreate() {
        //when
        final Expression expression = Expression.newInstance(1, 3, CalculateType.SUM);

        //then
        assertThat(expression).isNotNull();
    }

    @ParameterizedTest
    @DisplayName("식 계산 테스트")
    @CsvSource({"1,5,+,6", "5,1,/,5", "3,3,*,9", "5,5,-,0"})
    void testResult(int first, int second, String calculatorSign, int result) {
        //when
        final Expression expression = Expression.newInstance(first, second, CalculateType.findBySign(calculatorSign));
        final int resultFromExpression = expression.result();

        //then
        assertThat(resultFromExpression).isEqualTo(result);
    }
}