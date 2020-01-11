package com.teamzunior.stringcalculator.calculation;


import com.teamzunior.stringcalculator.operator.Operators;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Calculation {

    private static final String SPLIT_TOKEN = "\\s";

    private Operators registeredOperators;
    private CalculationNumbers calculationNumbers;
    private CalculationOperators calculationOperators;

    public Calculation(final String calculationString, Operators registeredOperators) {
        assert !StringUtils.isEmpty(calculationString);
        assert registeredOperators != null;

        this.registeredOperators = registeredOperators;

        final List<String> values = Arrays.asList(calculationString.split(SPLIT_TOKEN));

        this.calculationNumbers = createNumbers(values);
        this.calculationOperators = createOperators(values);

        validate();
    }

    private CalculationNumbers createNumbers(List<String> values) {
        final List<BigDecimal> numbers = new ArrayList<>();

        for (int i = 0; i < values.size(); i += 2) {
            numbers.add(new BigDecimal(values.get(i)));
        }

        return new CalculationNumbers(numbers);
    }

    private CalculationOperators createOperators(List<String> values) {
        List<String> operators = new ArrayList<>();

        for (int i = 1; i < values.size(); i += 2) {
            final String value = values.get(i);
            registeredOperators.validate(value);

            operators.add(value);
        }

        return new CalculationOperators(operators);
    }

    private void validate() {
        if (!isCorrectFormula()) {
            throw new RuntimeException("연산식이 잘못되었습니다");
        }
    }

    private boolean isCorrectFormula() {
        return (calculationOperators.size() + 1) == calculationNumbers.size();
    }

    public BigDecimal apply() {
        int numberIndex = 0;

        final Iterator<String> operateIterator = calculationOperators.iterator();

        BigDecimal registry = calculationNumbers.getByIndex(numberIndex++);

        while (operateIterator.hasNext()) {
            final String operator = operateIterator.next();
            final BigDecimal nextNumber = calculationNumbers.getByIndex(numberIndex++);
            registeredOperators.apply(operator, registry, nextNumber);
        }

        return registry;
    }

}
