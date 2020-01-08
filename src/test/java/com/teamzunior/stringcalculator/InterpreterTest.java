package com.teamzunior.stringcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class InterpreterTest {
    @ParameterizedTest
    @MethodSource
    public void interpretTest(Formula expectedFormula, String input) {
        Interpreter interpreter = new Interpreter();

        Formula formula = interpreter.interpret(input);

        assertThat(formula).isEqualTo(expectedFormula);
    }

    private static Stream interpretTest() {
        return Stream.of(
                Arguments.of(new Formula(1, "+", "2"), "1+2")
        );
    }
}
