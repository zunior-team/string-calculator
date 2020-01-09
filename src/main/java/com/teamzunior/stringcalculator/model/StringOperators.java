package com.teamzunior.stringcalculator.model;

import com.teamzunior.stringcalculator.service.StringOperator;
import com.teamzunior.stringcalculator.service.impl.DivideStringOperator;
import com.teamzunior.stringcalculator.service.impl.MinusStringOperator;
import com.teamzunior.stringcalculator.service.impl.MultiplyStringOperator;
import com.teamzunior.stringcalculator.service.impl.PlusStringOperator;

import java.util.HashMap;
import java.util.Map;

public class StringOperators {
    private Map<String, StringOperator> operatorMap = new HashMap<>();

    public StringOperators() {
        operatorMap.put("+", new PlusStringOperator());
        operatorMap.put("-", new MinusStringOperator());
        operatorMap.put("*", new MultiplyStringOperator());
        operatorMap.put("/", new DivideStringOperator());
    }

    public Integer operate(String operator, String a, String b) {
        if(!operatorMap.containsKey(operator))
            throw new RuntimeException(operator + " is not acceptable.");
        return operatorMap.get(operator).operate(a, b);
    }
}
