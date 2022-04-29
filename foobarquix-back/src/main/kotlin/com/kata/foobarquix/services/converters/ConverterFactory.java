package com.kata.foobarquix.services.converters;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConverterFactory {

    private static final String FOO = "Foo";
    private static final String BAR = "Bar";
    private static final String QUIX = "Quix";
    private static final int FOO_NUMBER = 3;
    private static final int BAR_NUMBER = 5;
    private static final int QUIX_NUMBER = 7;

    public static final List<Integer> convertableNumbersList = Collections.unmodifiableList(Arrays.asList(FOO_NUMBER, BAR_NUMBER, QUIX_NUMBER));

    public NumberConverter createDividableConverter(Integer convertableNumber) {
        if (convertableNumber == FOO_NUMBER) {
            return new DividableConverter(FOO, convertableNumber);
        } else if (convertableNumber == BAR_NUMBER) {
            return new DividableConverter(BAR, convertableNumber);
        }
        return null;
    }

    public NumberConverter createContainsConverter(Integer convertableNumber) {
        if (convertableNumber == FOO_NUMBER) {
            return new ContainsConverter(FOO, convertableNumber);
        } else if (convertableNumber == BAR_NUMBER) {
            return new ContainsConverter(BAR, convertableNumber);
        } else if (convertableNumber == QUIX_NUMBER) {
            return new ContainsConverter(QUIX, convertableNumber);
        }
        return null;
    }
}
