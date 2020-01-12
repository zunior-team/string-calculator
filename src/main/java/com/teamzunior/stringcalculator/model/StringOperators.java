package com.teamzunior.stringcalculator.model;

import com.teamzunior.stringcalculator.service.Operator;
import com.teamzunior.stringcalculator.service.impl.DivideOperator;
import com.teamzunior.stringcalculator.service.impl.MinusOperator;
import com.teamzunior.stringcalculator.service.impl.MultiplyOperator;
import com.teamzunior.stringcalculator.service.impl.PlusOperator;

import java.util.HashMap;
import java.util.Map;

public class StringOperators {
    private Map<String, Operator> operators = new HashMap<>();

    public StringOperators() {
        operators.put("+", new PlusOperator());
        operators.put("-", new MinusOperator());
        operators.put("*", new MultiplyOperator());
        operators.put("/", new DivideOperator());
    }

    public Operator get(String sign) {
        if (!operators.containsKey(sign)) {
            throw new RuntimeException(sign + " is not acceptable.");
        }
        return operators.get(sign);
    }
}
