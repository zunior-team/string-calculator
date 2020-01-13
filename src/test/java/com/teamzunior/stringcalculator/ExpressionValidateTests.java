package com.teamzunior.stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.teamzunior.stringcalculator.utils.ExpressionUtils.separateByBlank;
import static com.teamzunior.stringcalculator.utils.ExpressionUtils.validate;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExpressionValidateTests {

    @DisplayName(value = "정상식 검증")
    @ParameterizedTest
    @MethodSource
    void normalExpressionValidateTests(String[] expression) {
        assertTrue(validate(expression));
    }

    @DisplayName(value = "이상한 식 검증")
    @ParameterizedTest
    @MethodSource
    void abnormalExpressionValidateTests(String[] expression) {
        assertFalse(validate(expression));
    }

    private static Stream normalExpressionValidateTests() {
        return Stream.of(
                Arguments.of((Object) separateByBlank("6 + 6")),
                Arguments.of((Object) separateByBlank("3 - 2")),
                Arguments.of((Object) separateByBlank("18 / 3")),
                Arguments.of((Object) separateByBlank("2 * 6")),
                Arguments.of((Object) separateByBlank("14 - 4 * 2 + 10 / 3"))
        );
    }

    private static Stream abnormalExpressionValidateTests() {
        return Stream.of(
                Arguments.of((Object) separateByBlank("6+6")),
                Arguments.of((Object) separateByBlank("")),
                Arguments.of((Object) separateByBlank("18 / ")),
                Arguments.of((Object) separateByBlank("- 4 * 2 + 10 / 3"))
        );
    }
}
