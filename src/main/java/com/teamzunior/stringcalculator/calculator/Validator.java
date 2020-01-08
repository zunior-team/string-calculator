package com.teamzunior.stringcalculator.calculator;

import org.springframework.util.StringUtils;

/**
 * Created by qkrtjdehd123 on 2020-01-08
 */
final class Validator {

    static void checkValidOnInputString(final String line) {

        if(!StringUtils.isEmpty(line)){
            return;
        }

        throw new IllegalArgumentException("입력 값이 널 또는 빈 공백 문자열입니다.");
    }
}
