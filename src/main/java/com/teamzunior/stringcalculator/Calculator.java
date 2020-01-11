package com.teamzunior.stringcalculator;


import com.teamzunior.stringcalculator.calculation.Calculation;
import com.teamzunior.stringcalculator.operator.Operators;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

public class Calculator {

    private final Operators registerOperators;

    public Calculator(Operators registerOperators) {
        assert registerOperators != null;

        this.registerOperators = registerOperators;
    }

    public BigDecimal calculate(String input) {
        validate(input);

        final Calculation calculation = new Calculation(input, registerOperators);

        return calculation.apply();
    }

    private void validate(String input) {
        if (StringUtils.isEmpty(input)) {
            throw new RuntimeException("죄송합니다, 연산식이 없습니다");
        }
    }
}
