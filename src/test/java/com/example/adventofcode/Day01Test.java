package com.example.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day01Test {

    Day01 day01 = new Day01();

    @Test
    public void amountOfIncreaseGroupedTest() {
        assertEquals(1418, day01.getAmountIncreaseGrouped());
    }

    @Test
    public void amountOfIncreaseTest() {
        assertEquals(1374, day01.getAmountIncrease());
    }
}
