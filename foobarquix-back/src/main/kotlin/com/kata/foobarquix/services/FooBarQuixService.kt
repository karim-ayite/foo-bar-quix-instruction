package com.kata.foobarquix.services

import com.kata.foobarquix.services.converters.DefaultNumberConverter
import org.springframework.stereotype.Component

@Component
class FooBarQuixService {

    fun convertNumber(number: Int): String {

        val defaultNumberConverter = DefaultNumberConverter();

        val convertedNumber = defaultNumberConverter.convertNumber(number)

        return if (convertedNumber == "") number.toString() else convertedNumber
    }


}