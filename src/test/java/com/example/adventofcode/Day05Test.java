package com.example.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day05Test {

    Day05 day05 = new Day05();

    @Test
    public void straitUnsafePointsTest() {
        assertEquals(5632, day05.getGetAmountOfUnsafeStraitLocations());
    }

    @Test
    public void unsafePointsTest() {
        assertEquals(22213, day05.getGetAmountOfUnsafeLocations());
    }
}
