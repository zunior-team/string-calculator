package com.teamzunior.stringcalculator.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by qkrtjdehd123 on 2020-01-09
 */
@DisplayName("스플리터 테스트")
public class SplitterTest {

    @ParameterizedTest(name = "\"{0}\" 문자열을 공백을 기준으로 {1}개로 잘랐습니다.")
    @CsvSource({
            "1, 1",
            "1 + 2, 3",
            "1 + 20 * 43, 5",
            "1 + 10 - 55 / 21, 7"
    })
    @DisplayName("들어온 문자열을 공백을 기준으로 자른다.")
    void splitByWhiteSpaceTest(final String line, final int count) {

        final int length = Splitter.splitByWhiteSpace(line).length;
        assertThat(length).isEqualTo(count);
    }
}
