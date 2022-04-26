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
//        if (contains(convertableNumber,inputNumber)){
//            convertedNumber += String.valueOf(inputNumber).replaceAll(String.valueOf(convertableNumber),this.numberConvertion);
//        }
        return convertedNumber;
    }




}
