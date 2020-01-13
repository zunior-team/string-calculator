package com.teamzunior.stringcalculator.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 *
 * [ `private method 를 테스트 해야하는가` 에 대한 고찰 ]
 *
 * https://medium.com/@vadimpushtaev/how-to-test-private-methods-4bc57d4410ff
 *
 * Created by qkrtjdehd123 on 2020-01-09
 */
@DisplayName("값 단지 테스트")
class CalculatorAnswerPotTest {

    private CalculatorAnswerPot pot;

    @BeforeEach
    void setup() {
        this.pot = CalculatorAnswerPot.createPot();
    }

    @ParameterizedTest(name = "{0} 값의 결과는 \"{1}\" 입니다.")
    @MethodSource("elementsProviderForSuccess")
    @DisplayName("값 단지에서 값을 추출한다.")
    void getValueIfPotNotEmptyTest(final List<String> elements, final BigDecimal expectResult) {

        for(String element : elements) {
            pot.compute(element);
        }

        assertThat(pot.getValue()).isEqualTo(expectResult);
    }

    @ParameterizedTest(name = "{0} 값이 들어왔습니다.")
    @MethodSource("elementsProviderForThrow")
    @DisplayName("값 단지에서 값을 추출하는데 비어있기 때문에 에러가 발생한다.")
    void getValueIfPotNotEmptyElseThrowTest(final List<String> elements) {

        for(String element : elements) {
            pot.compute(element);
        }

        assertThrows(EmptyStackException.class, () -> pot.getValue());
    }

    static Stream<Arguments> elementsProviderForSuccess() {
        return Stream.of(
            arguments(Arrays.asList("1", "+", "4", "+", "5"), BigDecimal.valueOf(10)),
            arguments(Arrays.asList("1", "+", "4", "/", "5"), BigDecimal.valueOf(1)),
            arguments(Arrays.asList("1", "-", "4", "-", "5"), BigDecimal.valueOf(-8)),
            arguments(Arrays.asList("1", "+", "4", "*", "5"), BigDecimal.valueOf(25))
        );
    }

    /**
     * 에러 테스트를 위한 메소드 소스
     */
    static Stream<Arguments> elementsProviderForThrow() {
        return Stream.of(
                arguments(Collections.singletonList("+")),
                arguments(Arrays.asList("+", "-"))
        );
    }
}
