package com.kata.foobarquix.services.converters;

public class DividableConverter extends NumberConverter {


    public DividableConverter(String convertableNumber, int numberConversion) {
        super(convertableNumber,numberConversion);
    }

    @Override
    public String convert( int inputNumber) {
        String convertedNumber = "";

        if (isDivisable(convertableNumber,inputNumber)){
            convertedNumber += numberConversion;
        }

        return convertedNumber;
    }

}
