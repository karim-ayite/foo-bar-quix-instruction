package com.kata.foobarquix.services.converters;

import java.util.*;

public class InputNumberConverter {

    public static final String FOO = "Foo";
    public static final String BAR = "Bar";
    public static final String QUIX = "Quix";
    private static final int FOO_NUMBER = 3;
    private static final int BAR_NUMBER = 5;
    private static final int QUIX_NUMBER = 7;

    List<Integer> convertableNumbersList = Collections.unmodifiableList(Arrays.asList(FOO_NUMBER, BAR_NUMBER, QUIX_NUMBER));

    public String convertNumber(int inputNumber) {

        List<NumberConverter> numberConverters = initializeConvertersByContentOrderOfAppearance(inputNumber);

        Optional<String> convertedNumberOptional = numberConverters
                .stream()
                .map(numberConverter -> numberConverter.convert(inputNumber))
                .reduce(String::concat)
                .map(this::removeDigitsFromRowConvertedNumber);

        return convertedNumberOptional.orElse(String.valueOf(inputNumber));
    }

    private List<NumberConverter> initializeConvertersByContentOrderOfAppearance(int inputNumber) {
        List<NumberConverter> numbersConverters = new ArrayList<>();

        String inputNumberAsString = String.valueOf(inputNumber);

        initializeDivisableConverters(inputNumber, numbersConverters);

        initializeContainsConverters(numbersConverters, inputNumberAsString);

        return numbersConverters;
    }

    private void initializeContainsConverters(List<NumberConverter> numbersConverters, String inputNumberAsString) {
        List<Character> digitsConverted = new ArrayList<>();

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

    private void initializeDivisableConverters(int inputNumber, List<NumberConverter> numbersConverters) {
        for (int potentielConvertableNumber : convertableNumbersList) {
            if (NumberConverter.isDivisable(potentielConvertableNumber, inputNumber)) {
                addConverter(getDivisableConverter(potentielConvertableNumber), numbersConverters);
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

    private NumberConverter getDivisableConverter(Integer convertableNumber) {
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

    private String removeDigitsFromRowConvertedNumber(String convertedNumber) {
        return convertedNumber.replaceAll("\\d", "");
    }

}
