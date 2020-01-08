package com.teamzunior.stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1 + 2", "1+2", "2+1", "-1+2+2"})
    @DisplayName("더하기 테스트")
    void addTest(String input) {
        assertEquals(3, Calculator.calculate(input));
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("빼기 테스트")
    void subTest(String input, int expected) {
        assertEquals(expected, Calculator.calculate(input));
    }

    private static Stream subTest() {
        return Stream.of(
                Arguments.of("1 - 2", -1),
                Arguments.of("1-2", -1),
                Arguments.of("2-1", 1),
                Arguments.of("20-10", 10),
                Arguments.of("20-10-30-40", -60)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("곱하기 테스트")
    public void multiplyTest(String input, int expected) {
        assertEquals(expected, Calculator.calculate(input));
    }

    private static Stream multiplyTest() {
        return Stream.of(
                Arguments.of("1 * 2", 2),
                Arguments.of(" 1 * 2", 2),
                Arguments.of(" 1 * 2 ", 2),
                Arguments.of("1*2", 2),
                Arguments.of("2*1", 2),
                Arguments.of("1*-2", -2),
                Arguments.of("1*-2*-5", 10)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("나누기 테스트")
    void divideTest(String input, int expected) {
        assertEquals(expected, Calculator.calculate(input));
    }

    private static Stream divideTest() {
        return Stream.of(
                Arguments.of("100 / 10 / 2", 5),
                Arguments.of("10 / 2", 5),
                Arguments.of(" 10 / 3", 3),
                Arguments.of(" 10 / 5 ", 2),
                Arguments.of("1/2", 0),
                Arguments.of("2/1", 2),
                Arguments.of("1/-2", 0)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("나누기 테스트")
    void complicatedTest(String input, int expected) {
        assertEquals(expected, Calculator.calculate(input));
    }

    private static Stream complicatedTest() {
        return Stream.of(
                Arguments.of("10+20-40*-10/5", 20),
                Arguments.of("10+-20--20*-10/-10", 10)
        );
    }

    @ParameterizedTest
    @DisplayName("유효하지 않은 인풋 테스트")
    @ValueSource(strings = {"@+!", "@@@"})
    @NullAndEmptySource
    void invalidInputTest(String input) {
        assertThatThrownBy(() -> Calculator.calculate(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
