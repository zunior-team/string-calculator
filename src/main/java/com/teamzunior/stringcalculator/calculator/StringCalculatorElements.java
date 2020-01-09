package com.teamzunior.stringcalculator.calculator;


import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;

public class StringCalculatorElements {

    private List<Integer> numbers;
    private List<CalculateType> calculateTypes;

    public StringCalculatorElements(String[] elements) {
        final int lengthOfElements = elements.length;

        this.numbers = collectNumbers(elements, lengthOfElements);
        this.calculateTypes = collectCalculateTypes(elements, lengthOfElements);
    }

    private List<Integer> collectNumbers(String[] elements, int lengthOfElements) {
        return IntStream.range(0, lengthOfElements)
                .filter(num -> num % 2 == 0)
                .mapToObj(index -> parseInt(elements[index]))
                .collect(toList());
    }

    private List<CalculateType> collectCalculateTypes(String[] elements, int lengthOfElements) {
        return IntStream.range(0, lengthOfElements)
                .filter(num -> num % 2 == 1)
                .mapToObj(index -> CalculateType.findBySign(elements[index]))
                .collect(toList());
    }

    public int calculateAll() {
        int result = numbers.get(0);
        for (int calculateTypeIndex = 0; calculateTypeIndex < calculateTypes.size(); calculateTypeIndex++) {
            final int numbersIndex = calculateTypeIndex - 1;
            final int second = numbers.get(numbersIndex);

            final CalculateType calculateType = calculateTypes.get(calculateTypeIndex);
            result = Calculator.calculate(result, second, calculateType);
        }

        return result;
    }
}
