package com.teamzunior.stringcalculator.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OperatorsTest {

    @DisplayName("NEW 생성")
    @Test
    void testNewRegisterOperator() {
        assertDoesNotThrow(Operators::new);
    }

    @DisplayName("기본 연산자 테스트")
    @ParameterizedTest(name = "{1} {0} {2} == {3}")
    @CsvSource({"+, 3, 2, 5", "-, 3, 2, 1", "*, 3, 2, 6", "/, 6, 2, 3"})
    void testBasicOperator(String operator, double a, double b, double expected) {
        final Operators operators = new Operators();
        assertThat(operators.apply(operator, a, b)).isEqualTo(expected);
    }

    @DisplayName("커스텀 연산자 테스트")
    @Test
    void testCustomOperator() {
        //given
        final Operators operators = new Operators();
        final String operator = "^";

        operators.registerOperator(operator, (x, y) -> {
                    double result = x;

                    for (int i = 0; i < y - 1; i++) {
                        result *= x;
                    }
                    return result;
                }
        );

        //when, then
        assertThat(operators.apply(operator,2, 5)).isEqualTo(32);
    }

    @DisplayName("기본 연산자 파싱 테스트")
    @ParameterizedTest(name = "연산자 {0} 일 때")
    @ValueSource(strings = {"+", "-", "*", "/"})
    void testParseBasicOperator(String operator) {
        //given
        final Operators operators = new Operators();

        //when, then
        assertDoesNotThrow(() -> operators.parse(operator));
    }

    @DisplayName("커스텀 연산자 파싱 테스트")
    @Test
    void testParseCustomOperator() {
        //given
        final Operators operators = new Operators();
        final String operator = "^";
        operators.registerOperator(operator, (a, b) -> a * b * a * b);

        //when, then
        assertDoesNotThrow(() -> operators.parse(operator));
    }

    @DisplayName("잘못된 연산자 파싱 테스트")
    @ParameterizedTest(name = "연산자 {0} 일 때")
    @ValueSource(strings = {"@", "!"})
    void testParseWrongOperator(String operator) {
        //given
        final Operators operators = new Operators();

        //when, then
        assertThrows(RuntimeException.class, () -> operators.parse(operator));
    }
}
