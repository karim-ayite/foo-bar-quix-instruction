package com.kata.foobarquix.services

import com.kata.foobarquix.services.converters.InstructionNumberConverter
import org.springframework.stereotype.Component

@Component
class FooBarQuixService {

    fun convertNumber(number: Int): String {

        val instructionNumberConverter = InstructionNumberConverter();

        val convertedNumber = instructionNumberConverter.convertNumber(number)

        return if (convertedNumber == "") number.toString() else convertedNumber
    }


}