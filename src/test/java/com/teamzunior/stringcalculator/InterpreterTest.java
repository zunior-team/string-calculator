package com.teamzunior.stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.teamzunior.stringcalculator.Operator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InterpreterTest {
    private static Number one = new Number("1");
    private static Formula onePlusTwo = new Formula(2, PLUS, one);
    private static Formula onePlusTwoMinusThree = new Formula(3, MINUS, onePlusTwo);
    private static Formula onePlusTwoMinusThreeMultiplyFour = new Formula(4, MULTIPLY, onePlusTwoMinusThree);
    @DisplayName("인터프리트 테스트")
    @ParameterizedTest
    @MethodSource
    void interpretFormulaTest(Formula expectedFormula, String input) {
        Formula formula = (Formula) Interpreter.interpret(input);

        assertThat(formula).isEqualTo(expectedFormula);
    }

    private static Stream interpretFormulaTest() {
        return Stream.of(
                Arguments.of(new Formula(2, PLUS, one), "1+2"),
                Arguments.of(new Formula(3, MINUS, onePlusTwo), "1+2-3"),
                Arguments.of(new Formula(4, MULTIPLY, onePlusTwoMinusThree), "1+2-3*4"),
                Arguments.of(new Formula(5, DIVIDE, onePlusTwoMinusThreeMultiplyFour), "1+2-3*4/5")
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
