package com.teamzunior.stringcalculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    public static void init() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 2", "1+2", "2+1"})
    @DisplayName("더하기 테스트")
    public void addTest(String input) {
        assertEquals(3, calculator.calculate(input));
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("빼기 테스트")
    public void subTest(String input, int expected) {
        assertEquals(expected, calculator.calculate(input));
    }

    private static Stream subTest() {
        return Stream.of(
                Arguments.of("1 - 2", -1),
                Arguments.of("1-2", -1),
                Arguments.of("2-1", 1)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("빼기 테스트")
    public void multiplyTest(String input, int expected) {
        assertEquals(expected, calculator.calculate(input));
    }

    private static Stream multiplyTest() {
        return Stream.of(
                Arguments.of("1 * 2", 2),
                Arguments.of(" 1 * 2", 2),
                Arguments.of(" 1 * 2 ", 2),
                Arguments.of("1*2", 2),
                Arguments.of("2*1", 2),
                Arguments.of("1*-2", -2)
        );
    }

    @ParameterizedTest
    @DisplayName("유효하지 않은 인풋 테스트")
    @ValueSource(strings = {"@+!", "@@@"})
    @NullAndEmptySource
    public void invalidInputTest(String input) {
        assertThatThrownBy(() -> calculator.calculate(input)).isInstanceOf(IllegalArgumentException.class);

    }
}
