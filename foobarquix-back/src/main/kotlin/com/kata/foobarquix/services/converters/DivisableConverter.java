package com.kata.foobarquix.services.converters;

public class DivisableConverter extends NumberConverter {


    public DivisableConverter(String convertableNumber,int numberConvertion) {
        super(convertableNumber,numberConvertion);
    }


    @Override
    public String convert( int inputNumber) {
        String convertedNumber = "";

        if (isDivisable(convertableNumber,inputNumber)){
            convertedNumber += numberConvertion;
        }

        return convertedNumber;
    }




}
