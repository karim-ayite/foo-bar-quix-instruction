package com.kata.foobarquix.services.converters;

import java.util.*;

public class InputNumberConverter {

    public static final String FOO = "Foo";
    public static final String BAR = "Bar";
    public static final String QUIX = "Quix";

    List<Integer> convertableNumbersList = Collections.unmodifiableList(Arrays.asList(3, 5, 7));

    public String convertNumber(int inputNumber) {
        List<NumberConverter> convertableNumbers = initializeConverterByOrderOfAppearance(inputNumber);
        Optional<String> convertedNumberOptional = convertableNumbers
                .stream()
                .map(numberConverter -> numberConverter.convert(inputNumber))
                .reduce((s, s2) -> s.concat(s2))
                .map(convertedNumber -> removeNumberDigits(convertedNumber));

        return convertedNumberOptional.orElse(String.valueOf(inputNumber));
    }

    private List<NumberConverter> initializeConverterByOrderOfAppearance(int inputNumber) {
        List<NumberConverter> convertableNumbers = new ArrayList<>();
        String inputNumberAsString = String.valueOf(inputNumber);

        for (int i = 0; i < convertableNumbersList.size(); i++) {
            int potentielConvertableNumber = convertableNumbersList.get(i);
            if (NumberConverter.isDivisable(potentielConvertableNumber, inputNumber)) {
                addConverter(getDivisableConverter(potentielConvertableNumber), convertableNumbers);
            }
        }

        List<Character> digitsConverted = new ArrayList<>();

        for (int i = 0; i < inputNumberAsString.length(); i++) {

            char digit = inputNumberAsString.charAt(i);
            if (isDigitAlreadyHaveHisConverter(digitsConverted, digit)) {
                digitsConverted.add(digit);

                int potentielConvertableNumber = digit - '0';

                for (int j = 0; j < convertableNumbersList.size(); j++) {
                    int convertableNumber = convertableNumbersList.get(j);
                    if (NumberConverter.contains(potentielConvertableNumber, convertableNumber)) {
                        addConverter(getContainsConverter(potentielConvertableNumber), convertableNumbers);
                    }
                }
            }
        }

        return convertableNumbers;
    }

    private boolean isDigitAlreadyHaveHisConverter(List<Character> digitsConverted, char digit) {
        return !digitsConverted.contains(digit);
    }

    private void addConverter(NumberConverter potentielConvertableNumber, List<NumberConverter> convertableNumbers) {
        NumberConverter containsConverter = potentielConvertableNumber;
        if (containsConverter != null) {
            convertableNumbers.add(containsConverter);
        }
    }

    private NumberConverter getDivisableConverter(Integer convertableNumber) {
        if (convertableNumber == 3) {
            return new DivisableConverter(FOO, convertableNumber);
        } else if (convertableNumber == 5) {
            return new DivisableConverter(BAR, convertableNumber);
        }
        return null;
    }

    private NumberConverter getContainsConverter(Integer convertableNumber) {
        if (convertableNumber == 3) {
            return new ContainsConverter(FOO, convertableNumber);
        } else if (convertableNumber == 5) {
            return new ContainsConverter(BAR, convertableNumber);
        } else if (convertableNumber == 7) {
            return new ContainsConverter(QUIX, convertableNumber);
        }
        return null;
    }

    private String removeNumberDigits(String convertedNumber) {
        return convertedNumber.replaceAll("\\d", "");
    }

}
