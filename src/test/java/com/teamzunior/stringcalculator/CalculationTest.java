package com.teamzunior.stringcalculator;

import com.teamzunior.stringcalculator.operator.Operators;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculationTest {

    @DisplayName("NEW 생성, 연산식이 NULL 일떄")
    @ParameterizedTest(name = "연산식 : {0}")
    @NullSource
    void testNewCalculation01(String calculationString) {
        assertThrows(AssertionError.class, () -> new Calculation(calculationString, new Operators()));
    }

    @DisplayName("NEW 생성, 연산식이 잘못됬을때")
    @ParameterizedTest(name = "연산식 : {0}")
    @EmptySource
    @ValueSource(strings = {"1 @ 2", "1 + 2 +", "1 + 2 @ 3"})
    void testNewCalculation02(String calculationString) {
        assertThrows(RuntimeException.class, () -> new Calculation(calculationString, new Operators()));
    }

    @DisplayName("NEW 생성 성공")
    @Test
    void testNewCalculation() {
        new Calculation("1 + 2", new Operators());
    }
}
