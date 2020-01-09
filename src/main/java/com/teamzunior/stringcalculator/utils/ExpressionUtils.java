package com.teamzunior.stringcalculator.utils;

import com.teamzunior.stringcalculator.model.ExpressionValue;
import com.teamzunior.stringcalculator.model.ExpressionValueWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Slf4j
public class ExpressionUtils {
    public static String[] separateByBlank(String expression) {
        return expression.split(" ");
    }

    public static Boolean validate(String[] expression) {
        ExpressionValueWrapper previousValue = new ExpressionValueWrapper();

        if(expression.length == 0) {
            return false;
        }

        if (!validateEachValue(expression, previousValue)) {
            return false;
        }

        if (!previousValue.isEqual(ExpressionValue.NUMBER)) {
            log.error("Last value must be number.");
            return false;
        }

        return true;
    }

    private static Boolean validateEachValue(String[] expression, ExpressionValueWrapper previousValue) {
        return Arrays.stream(expression)
                .allMatch(value -> validateSingleValue(previousValue, value));
    }

    private static Boolean validateSingleValue(ExpressionValueWrapper previousValue, String value) {
        if (StringUtils.isNumeric(value)) {
            return validateSingleNumberValue(previousValue);
        }
        return validateSingleOperatorValue(previousValue);
    }

    private static Boolean validateSingleOperatorValue(ExpressionValueWrapper previousValue) {
        if (previousValue.isNull()) {
            log.error("First value must be number.");
            return false;
        }
        if (previousValue.isEqual(ExpressionValue.OPERATOR)) {
            log.error("Two operators came out in a row.");
            return false;
        }
        previousValue.change(ExpressionValue.OPERATOR);
        return true;
    }

    private static Boolean validateSingleNumberValue(ExpressionValueWrapper previousValue) {
        if (!previousValue.isNull() && previousValue.isEqual(ExpressionValue.NUMBER)) {
            log.error("Two numbers came out in a row.");
            return false;
        }
        previousValue.change(ExpressionValue.NUMBER);
        return true;
    }
}
