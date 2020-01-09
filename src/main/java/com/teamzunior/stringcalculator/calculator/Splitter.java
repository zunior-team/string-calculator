package com.teamzunior.stringcalculator.calculator;

/**
 * Created by qkrtjdehd123 on 2020-01-09
 */
final class Splitter {

    private static final String WHITE_SPACE = "\\s";

    static String[] splitByWhiteSpace(final String line) {
        return line.split(WHITE_SPACE);
    }
}
