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
        Queue<Integer> numberQueue = new LinkedList<>(numbers);
        Queue<CalculateType> calculateTypeQueue = new LinkedList<>(calculateTypes);

        int result = numberQueue.poll();

        while (!CollectionUtils.isEmpty(numberQueue) && !CollectionUtils.isEmpty(calculateTypeQueue)) {
            final int argument = numberQueue.poll();
            final CalculateType calculateType = calculateTypeQueue.poll();

            result = Calculator.calculate(result, argument, calculateType);
        }

        return result;
    }
}
