package com.example.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day03Test {

    Day03 day03 = new Day03();

    @Test
    public void submarinePowerUsageTest() {
        assertEquals(3885894, day03.getSubmarinePowerUsage());
    }

    @Test
    public void submarineOxygen() {
        assertEquals(4375225, day03.getSubmarineOxygen());
    }
}
