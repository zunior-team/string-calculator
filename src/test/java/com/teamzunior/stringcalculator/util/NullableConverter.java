package com.teamzunior.stringcalculator.util;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.DefaultArgumentConverter;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

/**
 * Created by qkrtjdehd123 on 2020-01-09
 */
public class NullableConverter extends SimpleArgumentConverter {

    // parameterizeTest 로 들어온 `null` 문자열을 `null` 로 치환.

    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {

        if ("null".equals(source)) {
            return null;
        }
        return DefaultArgumentConverter.INSTANCE.convert(source, targetType);
    }
}
