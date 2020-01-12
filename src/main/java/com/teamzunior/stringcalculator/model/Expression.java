package com.teamzunior.stringcalculator.model;

import com.teamzunior.stringcalculator.service.Operator;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.teamzunior.stringcalculator.utils.ExpressionUtils.separateByBlank;
import static com.teamzunior.stringcalculator.utils.ExpressionUtils.validate;

public class Expression {
    private ExpressionOperands operands;
    private ExpressionOperators operators;

    public Expression(ExpressionOperands operands, ExpressionOperators operators) {
        this.operands = operands;
        this.operators = operators;
    }

    public static Expression create(String expressionString, StringOperators stringOperators) {
        String[] separatedExpression = separateByBlank(expressionString);

        if(!validate(separatedExpression)) {
            throw new RuntimeException();
        }

        List<Integer> operands = IntStream.range(0, separatedExpression.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> Integer.parseInt(separatedExpression[i]))
                .collect(Collectors.toList());

        List<Operator> operators = IntStream.range(0, separatedExpression.length)
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> stringOperators.get(separatedExpression[i]))
                .collect(Collectors.toList());

        return new Expression(
                new ExpressionOperands(operands),
                new ExpressionOperators(operators));
    }

    public Iterator<Integer> operandsIterator() {
        return operands.iterator();
    }

    public Iterator<Operator> operatorsIterator() {
        return operators.iterator();
    }
}
