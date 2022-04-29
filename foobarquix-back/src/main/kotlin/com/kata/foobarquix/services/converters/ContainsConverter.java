package com.kata.foobarquix.services.converters;

public class ContainsConverter extends NumberConverter {


    public ContainsConverter(String convertableNumber,int numberConvertion) {
        super(convertableNumber,numberConvertion);
    }

    @Override
    String convert(int inputNumber) {
        String convertedNumber = "";
        if (contains(convertableNumber,inputNumber)){
            convertedNumber += String.valueOf(inputNumber).replace(String.valueOf(convertableNumber),this.numberConversion);
        }
        return convertedNumber;
    }
}
