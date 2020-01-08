package com.teamzunior.stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.teamzunior.stringcalculator.Operator.DIVIDE;
import static com.teamzunior.stringcalculator.Operator.PLUS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InterpreterTest {
    @DisplayName("인터프리트 테스트")
    @ParameterizedTest
    @MethodSource
    void interpretTest(Formula expectedFormula, String input) {
        Formula formula = Interpreter.interpret(input);

        assertThat(formula).isEqualTo(expectedFormula);
    }

    private static Stream interpretTest() {
        return Stream.of(
                Arguments.of(new Formula(2, PLUS, "1"), "1+2"),
                Arguments.of(new Formula(3, PLUS, "1+2"), "1+2+3"),
                Arguments.of(new Formula(5, DIVIDE, "1+2-3*4"), "1+2-3*4/5")
        );
    }

    @DisplayName("유효하지 않은 인풋 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"!@#"})
    @NullAndEmptySource
    void invalidInputTest(String input) {
        assertThatThrownBy(() -> Interpreter.interpret(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
