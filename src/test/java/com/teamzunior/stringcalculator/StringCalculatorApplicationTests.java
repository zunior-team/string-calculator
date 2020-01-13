package com.teamzunior.stringcalculator;

import com.teamzunior.stringcalculator.service.StringCalculator;
import com.teamzunior.stringcalculator.service.impl.StringCalculatorUsingPolymorphism;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringCalculatorApplicationTests {

    private StringCalculator calculator = new StringCalculatorUsingPolymorphism();

    @DisplayName(value = "덧셈식 처리")
    @ParameterizedTest
    @ValueSource(strings = {"6 + 6", "2 + 10", "11 + 1"})
    void plusTest(final String expressionString) {
        assertResultInteger(expressionString, 12);
    }

    @DisplayName(value = "뺄셈식 처리")
    @ParameterizedTest
    @ValueSource(strings = {"2 - 1", "3 - 2", "34 - 33"})
    void minusTest(final String expressionString) {
        assertResultInteger(expressionString, 1);
    }

    @DisplayName(value = "곱셈식 처리")
    @ParameterizedTest
    @ValueSource(strings = {"1 * 12", "2 * 6", "3 * 4"})
    void multiplyTest(final String expressionString) {
        assertResultInteger(expressionString, 12);
    }

    @DisplayName(value = "나눗셈 처리")
    @ParameterizedTest
    @ValueSource(strings = {"12 / 2", "18 / 3", "6 / 1"})
    void divideTest(final String expressionString) {
        assertResultInteger(expressionString, 6);
    }

    @DisplayName(value = "복잡한 식 처리")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2", "14 - 4 * 2 + 10 / 3", "256 / 2 - 28 / 10 - 7 * 2 + 4"})
    void complexTest(final String expressionString) {
        assertResultInteger(expressionString, 10);
    }

    @DisplayName(value = "단일 숫자 처리")
    @ParameterizedTest
    @MethodSource
    void singleNumberTests(String expressionString, Integer result) {
        assertResultInteger(expressionString, result);
    }

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 에러 처리.")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyTest(final String expressionString) {
        assertRuntimeException(expressionString);
    }

    @DisplayName(value = "사칙 연산 외 연산기호 입력할 경우 에러 처리")
    @ParameterizedTest
    @ValueSource(strings = {"3 % 2", "4 ! 0", "5 ^ 7"})
    void invalidOperatorTest(final String expressionString) {
        assertRuntimeException(expressionString);
    }

    @DisplayName(value = "정상적인 식이 아닐 경우 에러 처리")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * ", "+ 3 - 2", "5 5 * 2 - 1", " 5 + + 6 - 3"})
    void invalidExpressionTest(final String expressionString) {
        assertRuntimeException(expressionString);
    }

    private void assertResultInteger(String expressionString, int expected) {
        assertThat(calculator.calculate(expressionString)).isEqualTo(expected);
    }

    private void assertRuntimeException(String expressionString) {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> calculator.calculate(expressionString));
    }

    private static Stream singleNumberTests() {
        return Stream.of(
                Arguments.of("6", 6),
                Arguments.of("10", 10),
                Arguments.of("7 ", 7)
        );
    }
}
