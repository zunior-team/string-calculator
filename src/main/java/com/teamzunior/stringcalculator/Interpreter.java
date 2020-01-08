package com.teamzunior.stringcalculator;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interpreter {
    private static final Pattern pattern = Pattern.compile("(\\ ?-?\\d+)(\\ ?[+|\\-|*|/]\\ ?)(.*)");

    private static final int OPERAND_INDEX = 1;
    private static final int OPERATOR_INDEX = 2;
    private static final int FORMULA_INDEX = 3;

    public static Formula interpret(String formula) {
        if(isInvalidInput(formula)) {
            throw new IllegalArgumentException("Invalid input : " + formula);
        }

        formula = formula.trim();
        Matcher matcher = pattern.matcher(formula);
        if(!matcher.find()) {
            return new Formula(interpretNumber(formula), formula);
        }

        int operand = interpretNumber(matcher.group(OPERAND_INDEX).trim());
        String operator = matcher.group(OPERATOR_INDEX).trim();
        String subFormula = matcher.group(FORMULA_INDEX).trim();

        return new Formula(operand, operator, subFormula);
    }

    private static int interpretNumber(String formula) {
        try {
            return Integer.parseInt(formula);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input : " + formula);
        }
    }

    private static boolean isInvalidInput(String formula) {
        return StringUtils.isEmpty(formula);
    }
}
