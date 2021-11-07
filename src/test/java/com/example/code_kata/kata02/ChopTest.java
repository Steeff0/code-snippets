package com.example.code_kata.kata02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ChopTest{

    static Stream<Arguments> intIntAndIntArrayProvider() {
        return Stream.of(
            arguments(-1, 3, new int[]{}),
            arguments(-1, 3, new int[]{1}),
            arguments(0,  1, new int[]{1}),
            arguments(0,  1, new int[]{1, 3, 5}),
            arguments(1,  3, new int[]{1, 3, 5}),
            arguments(2,  5, new int[]{1, 3, 5}),
            arguments(-1, 0, new int[]{1, 3, 5}),
            arguments(-1, 2, new int[]{1, 3, 5}),
            arguments(-1, 4, new int[]{1, 3, 5}),
            arguments(-1, 6, new int[]{1, 3, 5}),
            arguments(0,  1, new int[]{1, 3, 5, 7}),
            arguments(1,  3, new int[]{1, 3, 5, 7}),
            arguments(2,  5, new int[]{1, 3, 5, 7}),
            arguments(3,  7, new int[]{1, 3, 5, 7}),
            arguments(-1, 0, new int[]{1, 3, 5, 7}),
            arguments(-1, 2, new int[]{1, 3, 5, 7}),
            arguments(-1, 4, new int[]{1, 3, 5, 7}),
            arguments(-1, 6, new int[]{1, 3, 5, 7}),
            arguments(-1, 8, new int[]{1, 3, 5, 7})
        );
    }

    @DisplayName("Finding the index Solution 01")
    @ParameterizedTest(name = "{index} ==> search {1} in {2} results in {0}")
    @MethodSource("intIntAndIntArrayProvider")
    void testChoppingSolution01(int result, int search, int[] set) {
        Chopper chopper = new ChopperImpl01();
        assertEquals(result, chopper.chop(search, set));
    }

    @DisplayName("Finding the index Solution 01")
    @ParameterizedTest(name = "{index} ==> search {1} in {2} results in {0}")
    @MethodSource("intIntAndIntArrayProvider")
    void testChoppingSolution02(int result, int search, int[] set) {
        Chopper chopper = new ChopperImpl02();
        assertEquals(result, chopper.chop(search, set));
    }
}
