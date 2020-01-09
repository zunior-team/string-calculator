package com.teamzunior.stringcalculator.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by qkrtjdehd123 on 2020-01-09
 */
@DisplayName("연산자 셋 테스트")
class OperatorSetTest {


    @ParameterizedTest(name = "\"{0}\" 문자가 들어왔고, 불린타입은 {1}을 리턴했습니다.")
    @CsvSource({
            "+, true",
            "-, true",
            "*, true",
            "/, true",
            "1, false",
            "g, false",
            "ㅁ, false"
    })
    @DisplayName("기호가 포함되었으면 true 를 반환하고, 포함되지 않으면 false 를 반환한다.")
    public void containsSymbolTest(final String symbol, final Boolean bool) {

        assertThat(OperatorSet.containsSymbol(symbol)).isEqualTo(bool);
    }
}
