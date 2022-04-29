package com.kata.foobarquix.services.converters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListConverterInitializer {

    private static final String FOO = "Foo";
    private static final String BAR = "Bar";
    private static final String QUIX = "Quix";
    private static final int FOO_NUMBER = 3;
    private static final int BAR_NUMBER = 5;
    private static final int QUIX_NUMBER = 7;

    private final List<Integer> convertableNumbersList = Collections.unmodifiableList(Arrays.asList(FOO_NUMBER, BAR_NUMBER, QUIX_NUMBER));

    public List<NumberConverter> init(int inputNumber) {
        List<NumberConverter> numbersConverters = new ArrayList<>();

        initializeDividableConverters(inputNumber, numbersConverters);

        initializeContainsConverters(inputNumber, numbersConverters);

        return numbersConverters;
    }

    private void initializeContainsConverters(int inputNumber, List<NumberConverter> numbersConverters) {
        List<Character> digitsConverted = new ArrayList<>();
        String inputNumberAsString = String.valueOf(inputNumber);
        for (int i = 0; i < inputNumberAsString.length(); i++) {

            char digit = inputNumberAsString.charAt(i);
            if (!isDigitAlreadyHaveHisConverter(digitsConverted, digit)) {
                digitsConverted.add(digit);

                int potentialContainedNumber = convertDigitToInt(digit);

                for (int convertableNumber : convertableNumbersList) {
                    if (NumberConverter.contains(potentialContainedNumber, convertableNumber)) {
                        addConverter(getContainsConverter(potentialContainedNumber), numbersConverters);
                    }
                }
            }
        }
    }

    private int convertDigitToInt(char digit) {
        return digit - '0';
    }

    private void initializeDividableConverters(int inputNumber, List<NumberConverter> numbersConverters) {
        for (int potentialDividableNumber : convertableNumbersList) {
            if (NumberConverter.isDivisable(potentialDividableNumber, inputNumber)) {
                addConverter(getDividableConverter(potentialDividableNumber), numbersConverters);
            }
        }
    }

    private boolean isDigitAlreadyHaveHisConverter(List<Character> digitsConverted, char digit) {
        return digitsConverted.contains(digit);
    }

    private void addConverter(NumberConverter potentialConvertibleNumber, List<NumberConverter> convertableNumbers) {
        if (potentialConvertibleNumber != null) {
            convertableNumbers.add(potentialConvertibleNumber);
        }
    }

    private NumberConverter getDividableConverter(Integer convertableNumber) {
        if (convertableNumber == FOO_NUMBER) {
            return new DivisableConverter(FOO, convertableNumber);
        } else if (convertableNumber == BAR_NUMBER) {
            return new DivisableConverter(BAR, convertableNumber);
        }
        return null;
    }

    private NumberConverter getContainsConverter(Integer convertableNumber) {
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
