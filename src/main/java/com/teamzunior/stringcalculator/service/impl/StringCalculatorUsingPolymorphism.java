package com.teamzunior.stringcalculator.service.impl;

import com.teamzunior.stringcalculator.model.Expression;
import com.teamzunior.stringcalculator.model.StringOperators;
import com.teamzunior.stringcalculator.service.StringCalculator;
import com.teamzunior.stringcalculator.service.Operator;

import java.util.Iterator;

public class StringCalculatorUsingPolymorphism implements StringCalculator {
    private StringOperators operators = new StringOperators();

    @Override
    public Integer calculate(String expressionString) {
        Expression expression = Expression.create(expressionString, operators);
        return calculateExpression(expression);
    }

    public Integer calculateExpression(Expression expression) {
        Iterator<Integer> operandsIterator = expression.operandsIterator();
        Iterator<Operator> operatorIterator = expression.operatorsIterator();

        Integer result = operandsIterator.next();
        while(operandsIterator.hasNext()) {
            Operator nextOperator = operatorIterator.next();
            Integer nextValue = operandsIterator.next();
            result = nextOperator.operate(result, nextValue);
        }

        return result;
    }
}
