package com.kata.foobarquix.services.converters;

import java.util.*;

public class InstructionNumberConverter {

    public String convertNumber(int inputNumber) {

        List<NumberConverter> numberConverters = new ListConverterInitializer().init(inputNumber);

        Optional<String> convertedNumberOptional = numberConverters
                .stream()
                .map(numberConverter -> numberConverter.convert(inputNumber))
                .reduce(String::concat)
                .map(this::removeDigitsFromRawConvertedNumberString);

        return convertedNumberOptional.orElse(String.valueOf(inputNumber));
    }

    private String removeDigitsFromRawConvertedNumberString(String convertedNumber) {
        return convertedNumber.replaceAll("\\d", "");
    }

}
