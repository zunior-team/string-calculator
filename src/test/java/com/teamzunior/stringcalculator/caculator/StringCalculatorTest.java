package com.teamzunior.stringcalculator.caculator;

import com.teamzunior.stringcalculator.calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("문자열 계산기 테스트")
class StringCalculatorTest {


    @ParameterizedTest
    @DisplayName("문자열 계산 테스트")
    @CsvSource({"2 + 3 * 4 / 2,10", " 3 + 1 / 2 + 1 * 5,15", "5 / 1 * 1,5"})
    void calculateTest(String string, int result) {
        //given
        final String[] elements = string.split(" ");

        //when
        final int calculate = StringCalculator.calculate(elements);

        //then
        assertThat(calculate).isEqualTo(result);
    }
}