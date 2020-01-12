package com.teamzunior.stringcalculator.calculator;

import java.util.stream.Stream;

/**
 * Created by qkrtjdehd123 on 2020-01-09
 */
final class Splitter {

    private static final String WHITE_SPACE = "\\s";

    static Stream<String> splitByWhiteSpace(final String line) {
        return Stream.of(
                line.split(WHITE_SPACE));
    }
}
