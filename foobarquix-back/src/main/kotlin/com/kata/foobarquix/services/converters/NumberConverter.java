package com.kata.foobarquix.services.converters;

public abstract class NumberConverter {

    protected int convertableNumber;
    protected String numberConvertion;

    public NumberConverter(String numberConvertion,int convertableNumber) {
        this.numberConvertion = numberConvertion;
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
