package com.teamzunior.stringcalculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InterpreterTest {
    private static Interpreter interpreter;

    @BeforeAll
    static void init() {
        interpreter = new Interpreter();
    }

    @DisplayName("인터프리트 테스트")
    @ParameterizedTest
    @MethodSource
    void interpretTest(Formula expectedFormula, String input) {
        Formula formula = interpreter.interpret(input);

        assertThat(formula).isEqualTo(expectedFormula);
    }

    private static Stream interpretTest() {
        return Stream.of(
                Arguments.of(new Formula(1, "+", "2"), "1+2")
        );
    }

    @DisplayName("유효하지 않은 인풋 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void invalidInputTest(String input) {
        assertThatThrownBy(() -> interpreter.interpret(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
