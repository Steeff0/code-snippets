package com.example.code_kata.kata04;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherAnalyzerTest {

    WeatherAnalyzer weatherAnalyzer = new WeatherAnalyzer();

    @Test
    void testMaxTempDifferenceDay() {
        assertEquals(30, weatherAnalyzer.getMaxTempDifferenceDay());
    }
}
