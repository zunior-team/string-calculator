package com.teamzunior.stringcalculator.calculator;


import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class StringCalculatorElements {

    private List<Integer> numbers;
    private List<CalculateType> calculateTypes;

    public StringCalculatorElements(String[] elements) {
        final int lengthOfElements = elements.length;


        this.numbers = IntStream.range(0, lengthOfElements)
                .filter(num -> num % 2 == 0)
                .mapToObj(index -> Integer.parseInt(elements[index]))
                .collect(toList());

        this.calculateTypes = IntStream.range(0, lengthOfElements)
                .filter(num -> num % 2 == 1)
                .mapToObj(index -> CalculateType.findBySign(elements[index]))
                .collect(toList());
    }

    public int calculateAll() {
        int result = numbers.get(0);
        for (int i = 1; i <= calculateTypes.size(); i++) {
            final int first = result;
            final int second = numbers.get(i);
            final CalculateType calculateType = calculateTypes.get(i - 1);
            result = Calculator.calculate(first, second, calculateType);
        }

        return result;
    }
}
