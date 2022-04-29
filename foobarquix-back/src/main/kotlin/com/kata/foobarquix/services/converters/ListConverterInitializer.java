package com.kata.foobarquix.services.converters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListConverterInitializer {

    public static final String FOO = "Foo";
    public static final String BAR = "Bar";
    public static final String QUIX = "Quix";
    private static final int FOO_NUMBER = 3;
    private static final int BAR_NUMBER = 5;
    private static final int QUIX_NUMBER = 7;

    List<Integer> convertableNumbersList = Collections.unmodifiableList(Arrays.asList(FOO_NUMBER, BAR_NUMBER, QUIX_NUMBER));

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

                int potentielConvertableNumber = digit - '0';

                for (int convertableNumber : convertableNumbersList) {
                    if (NumberConverter.contains(potentielConvertableNumber, convertableNumber)) {
                        addConverter(getContainsConverter(potentielConvertableNumber), numbersConverters);
                    }
                }
            }
        }
    }

    private void initializeDividableConverters(int inputNumber, List<NumberConverter> numbersConverters) {
        for (int potentielConvertableNumber : convertableNumbersList) {
            if (NumberConverter.isDivisable(potentielConvertableNumber, inputNumber)) {
                addConverter(getDividableConverter(potentielConvertableNumber), numbersConverters);
            }
        }
    }

    private boolean isDigitAlreadyHaveHisConverter(List<Character> digitsConverted, char digit) {
        return digitsConverted.contains(digit);
    }

    private void addConverter(NumberConverter potentielConvertableNumber, List<NumberConverter> convertableNumbers) {
        if (potentielConvertableNumber != null) {
            convertableNumbers.add(potentielConvertableNumber);
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
