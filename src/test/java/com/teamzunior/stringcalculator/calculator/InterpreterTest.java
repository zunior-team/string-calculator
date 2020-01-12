package com.teamzunior.stringcalculator.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InterpreterTest {

    @ParameterizedTest
    @ValueSource(strings = {"5", "1000"})
    @DisplayName("숫자 변환")
    void testNumber(String input) {
        //when
        final int number = Interpreter.interpretNumber(input);

        //then
        assertThat(number).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @DisplayName("숫자변환 실패")
    @NullAndEmptySource
    @ValueSource(strings = {"asdf"})
    void testExceptionByNumber(String input) {

        //then
        assertThrows(IllegalArgumentException.class,
                //when
                () -> Interpreter.interpretNumber(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "/", "*"})
    @DisplayName("CalculatorType 변환")
    void testCalculatorType(String input) {
        //when
        final CalculateType calculateType = Interpreter.interpretCalculateType(input);

        //then
        assertThat(calculateType).isNotNull()
                .isOfAnyClassIn(CalculateType.class);
    }

    @ParameterizedTest
    @DisplayName("CalculatorType 변환 실패")
    @NullAndEmptySource
    @ValueSource(strings = {"asdf"})
    void testExceptionByCalculatorType(String input) {

        //then
        assertThrows(IllegalArgumentException.class,
                //when
                () -> Interpreter.interpretCalculateType(input));
    }
}