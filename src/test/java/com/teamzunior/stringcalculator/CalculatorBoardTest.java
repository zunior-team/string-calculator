package com.teamzunior.stringcalculator;

import com.teamzunior.stringcalculator.operator.Operators;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorBoardTest {

    @DisplayName("생성, 정상")
    @Test
    void testNewInstance01() {
        assertDoesNotThrow(() -> new CalculatorBoard(new Calculator(new Operators())));
    }

    @DisplayName("생성, calculator 가 null 일 때")
    @Test
    void testNewInstance02() {
        assertThrows(AssertionError.class, () -> new CalculatorBoard(null));
    }

    @DisplayName("종료 커맨드를 입력했을때")
    @ParameterizedTest(name = "{displayName} - {0}")
    @ValueSource(strings = {"exit", "Exit", "eXit", "EXIT"})
    void testWaitInput(String command) {

        //given
        final CalculatorBoard calculatorBoard = new CalculatorBoard(new Calculator(new Operators()));

        final ByteArrayInputStream in = new ByteArrayInputStream(command.getBytes());
        System.setIn(in);

        //when
        final int result = calculatorBoard.waitInput();

        //then
        assertThat(result).isEqualTo(CalculatorBoard.EXIT_CODE);
    }

}
