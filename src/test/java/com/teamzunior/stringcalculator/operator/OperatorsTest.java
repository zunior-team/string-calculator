package com.teamzunior.stringcalculator.operator;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.*;

class OperatorsTest {

    @DisplayName("NEW 생성")
    @Test
    void testNewRegisterOperator() {
        assertDoesNotThrow(Operators::new);
    }

    @DisplayName("기본 연산자")
    @ParameterizedTest(name = "{1} {0} {2} == {3}")
    @CsvSource({"+, 3, 2, 5", "-, 3.3, 2.1, 1.2", "*, 3, 2, 6", "/, 5, 2, 2.5"})
    void testBasicOperator(String operator, BigDecimal x, BigDecimal y, BigDecimal expected) {
        final Operators operators = new Operators();
        assertThat(operators.apply(operator, x, y)).isEqualTo(expected);
    }

    @DisplayName("커스텀 연산자 등록")
    @Test
    void testCustomOperator() {
        //given
        final Operators operators = new Operators();
        final String operator = "^";

        operators.registerOperator(operator, (x, y) -> x.pow(y.intValue()));

        //when, then
        final BigDecimal x = new BigDecimal(2);
        final BigDecimal y = new BigDecimal(5);
        final BigDecimal expected = new BigDecimal(32);

        assertThat(operators.apply(operator, x, y)).isEqualTo(expected);
    }

    @DisplayName("Validate, 기본 연산자 파싱")
    @ParameterizedTest(name = "연산자 {0} 일 때")
    @ValueSource(strings = {"+", "-", "*", "/"})
    void testParseBasicOperator(String operator) {
        //given
        final Operators operators = new Operators();

        //when, then
        assertDoesNotThrow(() -> operators.validate(operator));
    }

    @DisplayName("Validate, 커스텀 연산자 파싱")
    @Test
    void testParseCustomOperator() {
        //given
        final Operators operators = new Operators();
        final String operator = "^";
        operators.registerOperator(operator, (a, b) -> a);

        //when, then
        assertDoesNotThrow(() -> operators.validate(operator));
    }

    @DisplayName("Validate, 잘못된 연산자")
    @ParameterizedTest(name = "연산자 {0} 일 때")
    @ValueSource(strings = {"@", "!"})
    void testParseWrongOperator(String operator) {
        //given
        final Operators operators = new Operators();

        //when, then
        assertThrows(RuntimeException.class, () -> operators.validate(operator));
    }
}
