package com.teamzunior.stringcalculator.caculator;

import com.teamzunior.stringcalculator.calculator.CalculateType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

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

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = "blabla")
    @DisplayName("null 혹은 빈값 혹은 존재하지 않는 값 입력시 Exception을 던진다")
    void createFailTest(String sign) {

        //then
        assertThrows(IllegalArgumentException.class,
                //when
                () -> CalculateType.findBySign(sign));
    }

    @Test
    @DisplayName("각 sign은 Unique한 값으로 작성 되어있다.")
    void testUniqueSign() {
        //given
        final CalculateType[] values = CalculateType.values();

        //when
        final long uniqueSignCount = Arrays.stream(values)
                .map(CalculateType::getSign)
                .distinct().count();

        //then
        assertThat(values.length).isEqualTo(uniqueSignCount);
    }
}