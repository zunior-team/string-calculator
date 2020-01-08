package com.teamzunior.stringcalculator.service.impl;

import com.teamzunior.stringcalculator.model.StringOperators;
import com.teamzunior.stringcalculator.service.StringCalculator;

import java.util.Stack;

import static com.teamzunior.stringcalculator.utils.ExpressionSeparator.separateByBlank;

public class StringCalculatorUsingPolymorphism implements StringCalculator {
    private StringOperators operators;

    @Override
    public Integer calculate(String expression) {
        return calculate(separateByBlank(expression));
    }

    private Integer calculate(String[] expression) {
        Integer result = 0;
        Stack<String> operatorStack = new Stack<>();
/*        for(String target : expression) {
            if(!StringUtils.isNumeric(target))
                operatorStack.push(target);
            else {
            }
        }*/
        return result;
    }
}
