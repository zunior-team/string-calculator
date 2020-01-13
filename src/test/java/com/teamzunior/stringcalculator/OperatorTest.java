package com.teamzunior.stringcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.teamzunior.stringcalculator.Operator.*;
import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @ParameterizedTest
    @MethodSource
    void plusOperatorTest(int x, int y, int result) {
        assertThat(PLUS.operate(x, y)).isEqualTo(result);
    }

    private static Stream plusOperatorTest() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(-1, 2, 1)
        );
    }

    @ParameterizedTest
    @MethodSource
    void minusOperatorTest(int x, int y, int result) {
        assertThat(MINUS.operate(x, y)).isEqualTo(result);
    }

    private static Stream minusOperatorTest() {
        return Stream.of(
                Arguments.of(1, 2, -1),
                Arguments.of(-1, 2, -3)
        );
    }

    @ParameterizedTest
    @MethodSource
    void multiplyOperatorTest(int x, int y, int result) {
        assertThat(MULTIPLY.operate(x, y)).isEqualTo(result);
    }

    private static Stream multiplyOperatorTest() {
        return Stream.of(
                Arguments.of(1, 2, 2),
                Arguments.of(-1, 2, -2)
        );
    }

    @ParameterizedTest
    @MethodSource
    void divideOperatorTest(int x, int y, int result) {
        assertThat(DIVIDE.operate(x, y)).isEqualTo(result);
    }

    private static Stream divideOperatorTest() {
        return Stream.of(
                Arguments.of(10, 2, 5),
                Arguments.of(10, 5, 2)
        );
    }
}
