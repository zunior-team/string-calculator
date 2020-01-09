package com.teamzunior.stringcalculator.service.impl;

import com.teamzunior.stringcalculator.model.StringOperators;
import com.teamzunior.stringcalculator.service.StringCalculator;
import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

import static com.teamzunior.stringcalculator.utils.ExpressionUtils.separateByBlank;
import static com.teamzunior.stringcalculator.utils.ExpressionUtils.validate;

public class StringCalculatorUsingPolymorphism implements StringCalculator {
    private StringOperators operators = new StringOperators();

    @Override
    public Integer calculate(String expression) {
        return calculate(separateByBlank(expression));
    }

    private Integer calculate(String[] expression) {
        if (!validate(expression)) {
            throw new RuntimeException();
        }

        Integer result = null;
        Stack<String> stringOperatorStack = new Stack<>();

        for (String target : expression) {
            result = operate(result, stringOperatorStack, target);
        }

        return result;
    }

    private Integer operate(Integer result, Stack<String> stringOperatorStack, String target) {
        if (StringUtils.isNumeric(target)) {
            return operateWithNumber(result, stringOperatorStack, target);
        }
        return operateWithOperator(result, stringOperatorStack, target);
    }

    private Integer operateWithNumber(Integer result, Stack<String> stringOperatorStack, String target) {
        if (result == null) {
            return Integer.parseInt(target);
        }

        if (stringOperatorStack.empty()) {
            throw new RuntimeException("The Expression is not Valid: It must have more operator.");
        }

        String stringOperator = stringOperatorStack.pop();
        return operators.operate(stringOperator, String.valueOf(result), target);
    }

    private Integer operateWithOperator(Integer result, Stack<String> operatorStack, String target) {
        operatorStack.push(target);
        return result;
    }
}
