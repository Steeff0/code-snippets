package com.example.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day04Test {

    Day04 day04 = new Day04();

    @Test
    public void winningBingoBoardTest() {
        assertEquals(8580, day04.getWinningBingoScore());
    }

    @Test
    public void loosingBingoBoardTest() {
        assertEquals(9576, day04.getUltimateLooserScore());
    }
}
