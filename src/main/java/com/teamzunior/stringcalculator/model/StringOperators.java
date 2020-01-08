package com.teamzunior.stringcalculator.model;

import com.teamzunior.stringcalculator.service.StringOperator;
import com.teamzunior.stringcalculator.service.impl.StringDivideOperator;
import com.teamzunior.stringcalculator.service.impl.StringMinusOperator;
import com.teamzunior.stringcalculator.service.impl.StringMultiplyOperator;
import com.teamzunior.stringcalculator.service.impl.StringPlusOperator;

import java.util.HashMap;
import java.util.Map;

public class StringOperators {
    Map<String, StringOperator> operatorMap = new HashMap<>();

    public StringOperators() {
        operatorMap.put("+", new StringPlusOperator());
        operatorMap.put("-", new StringMinusOperator());
        operatorMap.put("*", new StringMultiplyOperator());
        operatorMap.put("/", new StringDivideOperator());
    }

    public Integer operate(String operator, String a, String b) {
        if(operatorMap.containsKey(operator))
            throw new RuntimeException(operator + " is not acceptable.");
        return operatorMap.get(operator).operate(a, b);
    }
}
