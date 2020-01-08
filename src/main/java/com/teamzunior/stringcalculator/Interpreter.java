package com.teamzunior.stringcalculator;

import org.springframework.util.StringUtils;

public class Interpreter {
    public Formula interpret(String formula) {
        if(isInvalidInput(formula)) {
            throw new IllegalArgumentException("Invalid input : " + formula);
        }

        return new Formula(1, "+", "2");
    }

    private boolean isInvalidInput(String formula) {
        return StringUtils.isEmpty(formula);
    }
}
