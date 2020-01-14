package com.teamzunior.stringcalculator.caculator;

import com.teamzunior.stringcalculator.calculator.CalculateType;
import com.teamzunior.stringcalculator.calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("일반 계산기 테스트")
class CalculatorTest {

    @ParameterizedTest
    @DisplayName("CalculateType은 NULL 일 수 없다")
    @CsvSource({"1,2", "-1,3", "0,0", "12345,1234"})
    void checkNull(int first, int second) {

        //then
        final IllegalArgumentException thrown =
                assertThrows(IllegalArgumentException.class,
                        //given & when
                        () -> Calculator.calculate(first, second, null));
        assertThat(thrown.getMessage()).isEqualToIgnoringCase("calculateType must not be null");
    }

    @DisplayName("덧셈 테스트")
    @ParameterizedTest(name = "{0} + {1}  -> {2}")
    //given
    @CsvSource({"1,2,3", "-1,3,2", "0,0,0", "12345,1234,13579"})
    void sumTest(int first, int second, int correctResult) {
        //when
        final int result = Calculator.calculate(first, second, CalculateType.SUM);

        //then
        assertThat(result).isEqualTo(correctResult);
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest(name = "{0} - {1}  -> {2}")
    //given
    @CsvSource({"1,2,-1", "-1,3,-4", "0,0,0", "12345,1234,11111"})
    void subTest(int first, int second, int correctResult) {
        //when
        final int result = Calculator.calculate(first, second, CalculateType.SUB);

        //then
        assertThat(result).isEqualTo(correctResult);
    }

    @DisplayName("곱셈 테스트")
    @ParameterizedTest(name = "{0} * {1}  -> {2}")
    //given
    @CsvSource({"1,2,2", "-1,3,-3", "0,0,0", "12345,1234,15233730"})
    void multiplyTest(int first, int second, int correctResult) {
        //when
        final int result = Calculator.calculate(first, second, CalculateType.MULTI);

        //then
        assertThat(result).isEqualTo(correctResult);
    }

    @DisplayName("나눗셈 테스트")
    @ParameterizedTest(name = "{0} / {1}  -> {2}")
    //given
    @CsvSource({"2,1,2", "-15,3,-5", "0,1,0", "15233730,12345,1234"})
    void divideTest(int first, int second, int correctResult) {
        //when
        final int result = Calculator.calculate(first, second, CalculateType.DIV);

        //then
        assertThat(result).isEqualTo(correctResult);
    }

    @ParameterizedTest
    @DisplayName("오버플로우시 Exception을 던진다")
    @CsvSource({"2147483647,+,999999999", "10000000,*,12345678"})
    void handleOverFlow(String first, String sign, String second) {
        //given
        int firstParameter = Integer.parseInt(first);
        int secondParameter = Integer.parseInt(second);
        final CalculateType calculateType = CalculateType.findBySign(sign);

        //then
        assertThrows(ArithmeticException.class,
                //when
                () -> Calculator.calculate(firstParameter, secondParameter, calculateType));
    }

}