package com.kata.foobarquix.services.converters;

public abstract class NumberConverter {

    protected int convertableNumber;
    protected String numberConversion;

    public NumberConverter(String numberConversion,int convertableNumber) {
        this.numberConversion = numberConversion;
        this.convertableNumber = convertableNumber;
    }

    abstract String convert(int inputNumber);

    public static boolean contains(Integer convertableNumber, int inputNumber) {
        return String.valueOf(inputNumber).contains(String.valueOf(convertableNumber));
    }

    public static boolean isDivisable(Integer convertableNumber, int inputNumber) {
        return inputNumber % convertableNumber == 0;
    }
}
