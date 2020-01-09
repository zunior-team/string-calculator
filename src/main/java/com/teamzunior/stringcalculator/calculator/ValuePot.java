package com.teamzunior.stringcalculator.calculator;

import com.teamzunior.stringcalculator.exception.EmptyResultException;
import com.teamzunior.stringcalculator.operator.OperatorSet;

import java.math.BigDecimal;
import java.util.EmptyStackException;
import java.util.Optional;
import java.util.Stack;

/**
 * Created by qkrtjdehd123 on 2020-01-09
 */
final class ValuePot {

    private Optional<OperatorComputer> optionalComputer = Optional.empty();
    private final Stack<BigDecimal> pot = new Stack<>();
    private final OperatorComputer[] computers = OperatorComputer.values();

    private ValuePot(){}

    static ValuePot createPot(){
        return new ValuePot();
    }

    BigDecimal getValue() {

        if(pot.empty()) {
            throw new EmptyStackException();
        }

        return pot.pop();
    }

    void compute(final String element) {

        for(OperatorComputer computer : computers){

            this.optionalComputer = (computer.findComputerBySymbol(element).isPresent())
                    ? Optional.of(computer)
                    : this.optionalComputer;
        }

        if(OperatorSet.containsSymbol(element)){
            return;
        }

        computeIfExistElsePush(getBigInteger(stringToInteger(element)));
    }


    private Integer stringToInteger(final String number) {
        return Integer.parseInt(number);
    }

    private BigDecimal getBigInteger(final Integer number) {
        return BigDecimal.valueOf(number);
    }

    private void computeIfExistElsePush(final BigDecimal number){

        if(pot.empty()) {
            pot.push(number);
            return;
        }

        pot.push(optionalComputer
                .orElseThrow(() -> new EmptyResultException("연산을 수행할 컴퓨터가 존재하지 않습니다."))
                .calculate(pot.pop(), number));
    }
}
