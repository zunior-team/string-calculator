package com.teamzunior.stringcalculator;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interpreter {
    private static final Pattern pattern = Pattern.compile("(.+)\\b([+\\-*/])(-?\\d+)");
    private static final int FORMULA_INDEX = 1;
    private static final int OPERATOR_INDEX = 2;
    private static final int OPERAND_INDEX = 3;
    private static final String BLANK = "\\s";

    public static Expression interpret(String formula) {
        formula = validateAndRefineFormulaString(formula);

        Matcher matcher = pattern.matcher(formula);

        if(isNumber(matcher)) {
            return new Number(formula);
        }

        return new Formula(
                Integer.parseInt(matcher.group(OPERAND_INDEX)),
                Operators.convert(matcher.group(OPERATOR_INDEX)),
                Interpreter.interpret(matcher.group(FORMULA_INDEX))
        );
    }

    private static boolean isNumber(Matcher matcher) {
        return !matcher.find();
    }

    private static String validateAndRefineFormulaString(String formula) {
        if(StringUtils.isEmpty(formula)) {
            throw new IllegalArgumentException("Invalid input : " + formula);
        }

        return refineFormula(formula);
    }

    private static String refineFormula(String formula) {
        return formula.trim()
                .replaceAll(BLANK, "");
    }
}
