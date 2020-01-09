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
        Stack<String> operatorStack = new Stack<>();

        for (String target : expression) {
            result = operate(result, operatorStack, target);
        }

        return result;
    }

    private Integer operate(Integer result, Stack<String> operatorStack, String target) {
        if (StringUtils.isNumeric(target)) {
            return handleNumber(result, operatorStack, target);
        }
        return handleOperator(result, operatorStack, target);
    }

    private Integer handleNumber(Integer result, Stack<String> operatorStack, String target) {
        if (result == null) {
            return Integer.parseInt(target);
        }

        if (operatorStack.empty()) {
            throw new RuntimeException("The Expression is not Valid: It must have more operator.");
        }

        String operator = operatorStack.pop();
        return operators.operate(operator, String.valueOf(result), target);
    }

    private Integer handleOperator(Integer result, Stack<String> operatorStack, String target) {
        operatorStack.push(target);
        return result;
    }
}
