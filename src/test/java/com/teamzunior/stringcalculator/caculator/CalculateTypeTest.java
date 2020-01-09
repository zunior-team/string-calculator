package com.teamzunior.stringcalculator.caculator;

import com.teamzunior.stringcalculator.calculator.CalculateType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("계산 타입 테스트")
class CalculateTypeTest {

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "/", "*"})
    @DisplayName("수학 기호로 적절한 타입 찾기 테스트")
    void createTest(String sign) {
        // when
        final CalculateType foundType = CalculateType.findBySign(sign);

        // then
        assertThat(foundType).isNotNull();
    }

    @Test
    @DisplayName("지정된 기호가 아닌 값 입력시 Exception을 던진다")
    void createFailTest() {

        //then
        assertThrows(IllegalArgumentException.class,
                //when
                () -> CalculateType.findBySign("blabla"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 혹은 빈값 입력시 Exception을 던진다")
    void createFailTest(String sign) {

        //then
        assertThrows(IllegalArgumentException.class,
                //when
                () -> CalculateType.findBySign(sign));
    }

}