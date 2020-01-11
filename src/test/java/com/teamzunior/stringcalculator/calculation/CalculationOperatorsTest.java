package com.teamzunior.stringcalculator.calculation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculationOperatorsTest {

    @DisplayName("생성")
    @Test
    void testNewInstance01() {
        assertDoesNotThrow(() -> new CalculationOperators(Collections.singletonList("+")));
    }


    @DisplayName("생성, Null Value")
    @ParameterizedTest(name = "{displayName} - {0}")
    @NullSource
    void testNewInstance02(List<String> operators) {
        assertThrows(AssertionError.class, () -> new CalculationOperators(operators));
    }

    @DisplayName("Size()")
    @ParameterizedTest
    @ValueSource(strings = {
            "A, B, C",
            "E, E, F",
    })
    void testSize(String numberGroupString){

        //given
        final List<String> operators = Arrays.asList(numberGroupString.split(","));

        final CalculationOperators calculationOperators = new CalculationOperators(operators);

        //when, then
        assertThat(calculationOperators.size()).isEqualTo(3);
    }

}