package com.teamzunior.stringcalculator.utils;

import com.teamzunior.stringcalculator.model.ExpressionValue;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.IntStream;

@Slf4j
public class ExpressionUtils {
    public static String[] separateByBlank(String expression) {
        return expression.split(" ");
    }

    public static Boolean validate(String[] expression) {
        if (expression.length == 0) {
            return false;
        }

        return validateAllValue(expression);
    }

    private static boolean validateAllValue(String[] expression) {
        ExpressionValue[] expressionValueTypes = new ExpressionValue[expression.length];
        return IntStream.range(0, expression.length)
                .allMatch(i -> validateSingleValue(expression, expressionValueTypes, i));
    }

    private static boolean validateSingleValue(String[] expression, ExpressionValue[] expressionValueTypes, int index) {
        if(StringUtils.isEmpty(expression[index])) {
            return false;
        }

        if (StringUtils.isNumeric(expression[index])) {
            return validateSingleNumberValue(expression, expressionValueTypes, index);
        }
        return validateSingleOperatorValue(expression, expressionValueTypes, index);
    }

    private static boolean validateSingleNumberValue(String[] expression, ExpressionValue[] expressionValueTypes, int index) {
        expressionValueTypes[index] = ExpressionValue.NUMBER;
        if (index == 0) {
            return true;
        }

        if (expressionValueTypes[index - 1].isNumber()) {
            log.error("Two numbers came out in a row.");
            return false;
        }

        return true;
    }

    private static Boolean validateSingleOperatorValue(String[] expression, ExpressionValue[] expressionValueTypes, int index) {
        expressionValueTypes[index] = ExpressionValue.OPERATOR;
        if (index == 0) {
            log.error("First value must be number.");
            return false;
        }

        if (index == expression.length - 1) {
            log.error("Last value must be number.");
            return false;
        }

        if (expressionValueTypes[index - 1].isOPERATOR()) {
            log.error("Two operators came out in a row.");
            return false;
        }
        return true;
    }
}
