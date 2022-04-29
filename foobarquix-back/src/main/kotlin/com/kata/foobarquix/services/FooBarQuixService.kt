package com.kata.foobarquix.services

import com.kata.foobarquix.services.converters.InputNumberConverter
import org.springframework.stereotype.Component

@Component
class FooBarQuixService {

    fun convertNumber(number: Int): String {

        val inputNumberConverter = InputNumberConverter();

        val convertedNumber = inputNumberConverter.convertNumber(number)

        return if (convertedNumber == "") number.toString() else convertedNumber
    }


}