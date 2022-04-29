package com.kata.foobarquix.services.converters;

import java.util.ArrayList;
import java.util.List;

public class ListConverterInitializer {

    public List<NumberConverter> init(int inputNumber) {
        List<NumberConverter> numbersConverters = new ArrayList<>();

        initializeDividableConverters(inputNumber, numbersConverters);

        initializeContainsConverters(inputNumber, numbersConverters);

        return numbersConverters;
    }

    private void initializeDividableConverters(int inputNumber, List<NumberConverter> numbersConverters) {
        ConverterFactory dividableConverterFactory= new ConverterFactory();
        for (int potentialDividableNumber : ConverterFactory.convertableNumbersList) {
            if (NumberConverter.isDivisable(potentialDividableNumber, inputNumber)) {
                addConverter(dividableConverterFactory.createDividableConverter(potentialDividableNumber), numbersConverters);
            }
        }
    }

    private void initializeContainsConverters(int inputNumber, List<NumberConverter> numbersConverters) {
        ConverterFactory containedConverterFactory= new ConverterFactory();
        List<Character> digitsConverted = new ArrayList<>();
        String inputNumberAsString = String.valueOf(inputNumber);

        for (int i = 0; i < inputNumberAsString.length(); i++) {

            char digit = inputNumberAsString.charAt(i);

            if (!isDigitAlreadyHaveHisConverter(digitsConverted, digit)) {
                digitsConverted.add(digit);

                int potentialContainedNumber = convertDigitToInt(digit);

                for (int convertableNumber : ConverterFactory.convertableNumbersList) {
                    if (NumberConverter.contains(potentialContainedNumber, convertableNumber)) {
                        addConverter(containedConverterFactory.createContainsConverter(potentialContainedNumber), numbersConverters);
                    }
                }
            }
        }
    }

    private boolean isDigitAlreadyHaveHisConverter(List<Character> digitsConverted, char digit) {
        return digitsConverted.contains(digit);
    }

    private int convertDigitToInt(char digit) {
        return digit - '0';
    }

    private void addConverter(NumberConverter potentialConvertibleNumber, List<NumberConverter> convertableNumbers) {
        if (potentialConvertibleNumber != null) {
            convertableNumbers.add(potentialConvertibleNumber);
        }
    }

}
