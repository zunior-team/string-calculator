package com.teamzunior.stringcalculator;


import com.teamzunior.stringcalculator.operator.OperatorFunction;
import com.teamzunior.stringcalculator.operator.Operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculation {

    private final Operators registerOperators;
    private final List<Double> numbers = new ArrayList<>();
    private final List<String> operators = new ArrayList<>();

    public Calculation(String calculationString, Operators registerOperators) {
        assert calculationString != null;
        assert registerOperators != null;

        this.registerOperators = registerOperators;

        final List<String> values = Arrays.asList(calculationString.split(" "));

        //짝수는 Number
        for (int i = 0; i < values.size(); i = i + 2) {
            numbers.add(Double.parseDouble(values.get(i)));
        }

        //홀수는 Operator
        for (int i = 1; i < values.size(); i = i + 2) {
            operators.add(registerOperators.parse(values.get(i)));
        }

        validate();
    }

    private void validate() {
        final int operatorSize = operators.size();
        final int numberSize = numbers.size();

        //이항연산식은 기본적으로 Operator 개수 * 2 가 Number 의 개수여야한다.
        if ((operatorSize == 0 && numberSize == 0) || (operatorSize * 2 != numberSize)) {
            throw new RuntimeException("죄송합니다, 연산식이 잘못되었습니다.");
        }
    }

    public double apply() {
        int numberIndex = 0;

        double registry = numbers.get(numberIndex++);

        for (String operator : operators) {
            registry = registerOperators.apply(operator, registry, numbers.get(numberIndex++));
        }

        return registry;
    }

}
