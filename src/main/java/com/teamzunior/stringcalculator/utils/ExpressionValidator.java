package com.teamzunior.stringcalculator.utils;

import org.apache.commons.lang3.StringUtils;

public class ExpressionValidator {
    public static Boolean isNumber(String target) {
        return StringUtils.isNumeric(target);
    }
}
