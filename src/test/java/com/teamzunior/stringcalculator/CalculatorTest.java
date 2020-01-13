package com.teamzunior.stringcalculator;

import com.teamzunior.stringcalculator.operator.Operators;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @DisplayName("새로운 Calculator 생성")
    @Test
    void testNewCalculator01(){
        assertDoesNotThrow(() -> {
            final Operators operators = new Operators();

            return new Calculator(operators);
        });
    }

    @DisplayName("새로운 Calculator 생성, Operator 가 Null 일 때")
    @Test
    void testNewCalculator02(){
        assertThrows(AssertionError.class, () -> new Calculator(null));
    }

    @DisplayName("NULL 또는 EMPTY 입력")
    @ParameterizedTest(name = "{displayName} - {0}")
    @NullAndEmptySource
    void testWrongCalculate(String calculation){
        assertThrows(RuntimeException.class, () -> {
            final Calculator calculator = new Calculator(new Operators());
            calculator.calculate(calculation);
        });
    }

}
