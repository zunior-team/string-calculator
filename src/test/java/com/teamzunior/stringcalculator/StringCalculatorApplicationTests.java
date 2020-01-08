package com.teamzunior.stringcalculator;

import com.teamzunior.stringcalculator.service.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringCalculatorApplicationTests {

    private StringCalculator calculator;

    @DisplayName(value = "덧셈식 처리")
    @ParameterizedTest
    @ValueSource(strings = {"6 + 6", "2 + 10", "11 + 1"})
    void plusTest(final String expression) {
        assertThat(calculator.calculate(expression)).isEqualTo(12);
    }

    @DisplayName(value = "뺄셈식 처리")
    @ParameterizedTest
    @ValueSource(strings = {"2 - 1", "3 - 2", "34 - 33"})
    void minusTest(final String expression) {
        assertThat(calculator.calculate(expression)).isEqualTo(1);
    }

    @DisplayName(value = "곱셈식 처리")
    @ParameterizedTest
    @ValueSource(strings = {"1 * 12", "2 * 6", "3 * 4"})
    void multiplyTest(final String expression) {
        assertThat(calculator.calculate(expression)).isEqualTo(1);
    }

    @DisplayName(value = "나눗셈 처리")
    @ParameterizedTest
    @ValueSource(strings = {"12 / 2", "18 / 3", "6 / 1"})
    void divideTest(final String expression) {
        assertThat(calculator.calculate(expression)).isEqualTo(6);
    }

    @DisplayName(value = "복잡한 식 처리")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2", "14 - 4 * 2 + 10 / 3", "256 / 2 - 28 / 10 - 7 * 2 + 4"})
    void complexTest(final String expression) {
        assertThat(calculator.calculate(expression)).isEqualTo(10);
    }

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 에러 처리.")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyTest(final String expression) {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> calculator.calculate(expression));
    }

    @DisplayName(value = "사칙 연산 외 연산기호 입력할 경우 에러 처리")
    @ParameterizedTest
    @ValueSource(strings = {"2 % 3", "4 !", "5 ^ 7"})
    void invalidOperatorTest(final String expression) {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> calculator.calculate(expression));
    }
}
