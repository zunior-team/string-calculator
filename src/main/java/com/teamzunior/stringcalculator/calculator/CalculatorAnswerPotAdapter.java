package com.teamzunior.stringcalculator.calculator;

import java.math.BigDecimal;
import java.util.stream.Stream;

final class CalculatorAnswerPotAdapter {

    /** 값을 쌓는 단지. **/
    private final CalculatorAnswerPot pot = CalculatorAnswerPot.createPot();

    CalculatorAnswerPotAdapter(){}

    BigDecimal compute(final Stream<String> elements){

        elements.forEach(pot::compute);

        return pot.getValue();
    }
}
