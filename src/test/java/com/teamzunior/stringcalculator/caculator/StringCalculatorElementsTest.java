package com.teamzunior.stringcalculator.caculator;

import com.teamzunior.stringcalculator.calculator.StringCalculatorElements;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.teamzunior.stringcalculator.calculator.InputListener.BLANK_DELIMITER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("StringCalculatorElements 테스트")
class StringCalculatorElementsTest {

    @Test
    @DisplayName("StringCalculatorElements 생성 테스트")
    void createTest() {
        //given
        final String[] elements = {"1", "+", "2", "-", "3"};
        //when
        final StringCalculatorElements stringCalculatorElements = new StringCalculatorElements(elements);

        //then
        assertThat(stringCalculatorElements).isNotNull();
    }

    @ParameterizedTest
    //given
    @ValueSource(strings = {"1 3 4", "+ 1 - 3 / 3", "1+23", "1 5 3 5", "- + - /", "1 a 3 b 4 c 3", "1 +  5"})
    @DisplayName("StringCalculatorElements 생성 실패 테스트")
    void createFailTest(String input) {

        //then
        assertThrows(IllegalArgumentException.class,
                //when
                () -> {
                    final String[] elements = input.split(BLANK_DELIMITER);
                    final StringCalculatorElements stringCalculatorElements = new StringCalculatorElements(elements);
                });
    }

    @ParameterizedTest
    @DisplayName("가지고 있는 elements 계산 테스트")
    @CsvSource({"2 + 3 * 4 / 2,10", " 3 + 1 / 2 + 1 * 5,15", "5 / 1 * 1,5"})
    void calculateTest(String string, int result) {
        //given
        final String[] elements = string.split(BLANK_DELIMITER);

        //when
        final int calculate = new StringCalculatorElements(elements).calculateAll();

        //then
        assertThat(calculate).isEqualTo(result);
    }
}