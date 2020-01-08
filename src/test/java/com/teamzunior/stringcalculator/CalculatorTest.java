package com.teamzunior.stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"1 + 2", "1+2", "2+1"})
    @DisplayName("더하기 테스트")
    public void addTest(String input) {
        Calculator calculator = new Calculator();

        assertEquals(3, calculator.calculate(input));
        assertThat(calculator.calculate(input)).isEqualTo(3);
    }
}
