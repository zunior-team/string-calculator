package com.teamzunior.stringcalculator.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Created by qkrtjdehd123 on 2020-01-09
 */
@DisplayName("연산컴퓨터 테스트")
class OperatorComputerTest {

    private BigDecimal a;
    private BigDecimal b;

    @BeforeEach
    public void setup() {

        // given
        a = BigDecimal.valueOf(5);
        b = BigDecimal.valueOf(10);
    }

    @ParameterizedTest
    @EnumSource(value = OperatorComputer.class, names = {"PLUS"})
    @DisplayName("연산 컴퓨터는 [덧셈] 연산을 수행한다.")
    void plusCalculateTest(OperatorComputer computer){

        assertThat(computer.calculate(a, b))
                .isEqualTo(BigDecimal.valueOf(15));
    }

    @ParameterizedTest
    @EnumSource(value = OperatorComputer.class, names = {"SUBTRACT"})
    @DisplayName("연산 컴퓨터는 [뺄셈] 연산을 수행한다.")
    void subtractCalculateTest(OperatorComputer computer){

        assertThat(computer.calculate(a, b))
                .isEqualTo(BigDecimal.valueOf(-5));
    }

    @ParameterizedTest
    @EnumSource(value = OperatorComputer.class, names = {"MULTIPLY"})
    @DisplayName("연산 컴퓨터는 [곱셈] 연산을 수행한다.")
    void multiplyCalculateTest(OperatorComputer computer){

        assertThat(computer.calculate(a, b))
                .isEqualTo(BigDecimal.valueOf(50));
    }

    @ParameterizedTest
    @EnumSource(value = OperatorComputer.class, names = {"DIVIDE"})
    @DisplayName("연산 컴퓨터는 [나눗셈] 연산을 수행한다.")
    void divideCalculateTest(OperatorComputer computer){

        assertThat(computer.calculate(a, b))
                .isEqualTo(BigDecimal.valueOf(0.5));
    }
}
