package com.teamzunior.stringcalculator.calculator;

import com.teamzunior.stringcalculator.util.NullableConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by qkrtjdehd123 on 2020-01-09
 */
@DisplayName("유효성 검사 테스트")
class ValidatorTest {

    @ParameterizedTest(name = "{0} 값이 들어왔습니다.")
    @CsvSource({"''", "null"})
    @DisplayName("널 값 또는 빈 공백이면 IllegalArgumentException 이 발생한다.")
    void checkValidOnInputStringTest(@ConvertWith(NullableConverter.class) final String line) {

        assertThrows(IllegalArgumentException.class,
                () -> Validator.checkValidOnInputString(line));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("널 값 또는 빈 공백이면 IllegalArgumentException 이 발생한다.")
    void checkValidOnInputStringSecondTest(final String line) {

        assertThrows(IllegalArgumentException.class,
                () -> Validator.checkValidOnInputString(line));
    }
}
