package com.teamzunior.stringcalculator;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.teamzunior.stringcalculator.Operator.*;

public class Interpreter {
    private static final Pattern pattern = Pattern.compile("(.+)\\b([+\\-*/])(-?\\d+)");
    private static final Map<String, Operator> operators;

    private static final int FORMULA_INDEX = 1;
    private static final int OPERATOR_INDEX = 2;
    private static final int OPERAND_INDEX = 3;

    public static Formula interpret(String formula) {
        Matcher matcher = validateFormulaAndExtractMatcher(formula);

        if(!isFullyFormula(matcher)) {
            return new Formula(interpretNumber(formula));
        }

        return new Formula(
                extractOperand(matcher),
                operators.get(extractOperator(matcher)),
                extractSubFormula(matcher)
        );
    }

    private static Matcher validateFormulaAndExtractMatcher(String formula) {
        if(isInvalidInput(formula)) {
            throw new IllegalArgumentException("Invalid input : " + formula);
        }

        formula = refineFormula(formula);

        return pattern.matcher(formula);
    }


    private static boolean isFullyFormula(Matcher matcher) {
        return matcher.find();
    }

    private static String extractSubFormula(Matcher matcher) {
        return matcher.group(FORMULA_INDEX).trim();
    }

    private static String extractOperator(Matcher matcher) {
        return matcher.group(OPERATOR_INDEX).trim();
    }

    private static Integer extractOperand(Matcher matcher) {
        return interpretNumber(matcher.group(OPERAND_INDEX).trim());
    }

    private static String refineFormula(String formula) {
        return formula.trim()
                .replaceAll(" ", "");
    }

    private static int interpretNumber(String formula) {
        try {
            return Integer.parseInt(refineFormula(formula));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input : " + formula);
        }
    }

    private static boolean isInvalidInput(String formula) {
        return StringUtils.isEmpty(formula);
    }

    static {
        operators = new HashMap<>();
        operators.put("+", PLUS);
        operators.put("-", MINUS);
        operators.put("*", MULTIPLY);
        operators.put("/", DIVIDE);
    }
}
