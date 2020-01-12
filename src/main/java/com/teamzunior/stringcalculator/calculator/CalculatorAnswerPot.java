package com.teamzunior.stringcalculator.calculator;

import com.teamzunior.stringcalculator.exception.EmptyResultException;
import com.teamzunior.stringcalculator.operator.OperatorComputer;
import com.teamzunior.stringcalculator.operator.OperatorSet;

import java.math.BigDecimal;
import java.util.EmptyStackException;
import java.util.Optional;
import java.util.Stack;

/**
 * Created by qkrtjdehd123 on 2020-01-09
 */
final class CalculatorAnswerPot {

    private OperatorComputer optionalComputer = null;
    private final Stack<BigDecimal> pot = new Stack<>();

    private CalculatorAnswerPot(){}

    static CalculatorAnswerPot createPot(){
        return new CalculatorAnswerPot();
    }

    BigDecimal getValue() {

        if(pot.empty()) {
            throw new EmptyStackException();
        }

        return pot.pop();
    }

    void compute(final String element) {

        Optional<OperatorComputer> optionalComputer = OperatorSet.findComputerBySymbol(element);

        if(!optionalComputer.isPresent()){
            computeIfExistElseSave(getBigInteger(stringToInteger(element)));
            return;
        }

        this.optionalComputer = optionalComputer.get();
    }


    private Integer stringToInteger(final String number) {
        return Integer.parseInt(number);
    }

    private BigDecimal getBigInteger(final Integer number) {
        return BigDecimal.valueOf(number);
    }

    private void computeIfExistElseSave(final BigDecimal number){

        if(pot.empty()) {
            pot.push(number);
            return;
        }

        pot.push(
                optionalComputer.calculate(
                        pot.pop(), number
                ));
    }
}
