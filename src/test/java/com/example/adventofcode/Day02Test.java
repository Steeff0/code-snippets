package com.example.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day02Test {

    Day02 day02 = new Day02();

    @Test
    public void submarineLocationTest() {
        assertEquals(1840243, day02.getSubmarineLocation());
    }

    @Test
    public void submarineLocationWithAimTest() {
        assertEquals(1727785422, day02.getSubmarineLocationWithAim());
    }
}
