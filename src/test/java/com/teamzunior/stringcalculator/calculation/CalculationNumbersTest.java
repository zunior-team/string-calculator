package com.teamzunior.stringcalculator.calculation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculationNumbersTest {

    @DisplayName("생성")
    @Test
    void testNewInstance01() {
        assertDoesNotThrow(() -> new CalculationNumbers(Arrays.asList(new BigDecimal(1), new BigDecimal(2))));
    }


    @DisplayName("생성, Null Value")
    @ParameterizedTest(name = "{displayName} - {0}")
    @NullSource
    void testNewInstance02(List<BigDecimal> numbers) {
        assertThrows(AssertionError.class, () -> new CalculationNumbers(numbers));
    }

    @DisplayName("Size()")
    @ParameterizedTest
    @ValueSource(strings = {
            "1, 2, 3.10",
            "1, 100, 3.4",
    })
    void testSize(String numberGroupString){

        //given
        final List<BigDecimal> numbers = Arrays.stream(numberGroupString.split(","))
                .map(String::trim)
                .map(BigDecimal::new)
                .collect(Collectors.toList());

        final CalculationNumbers calculationNumbers = new CalculationNumbers(numbers);

        //when, then
        assertThat(calculationNumbers.size()).isEqualTo(3);
    }

    @DisplayName("getByIndex()")
    @ParameterizedTest
    @ValueSource(strings = {
            "1, 2, 3.10",
            "1, 100, 3.4",
    })
    void testGetByIndex(String numberGroupString){

        //given
        final List<BigDecimal> numbers = Arrays.stream(numberGroupString.split(","))
                .map(String::trim)
                .map(BigDecimal::new)
                .collect(Collectors.toList());

        final CalculationNumbers calculationNumbers = new CalculationNumbers(numbers);

        //when, then
        assertThat(calculationNumbers.getByIndex(1)).isEqualTo(numbers.get(1));
    }
}