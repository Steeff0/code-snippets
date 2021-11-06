package com.example.code_kata.kata02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChopTest{

    Chopper chopper = new ChopperImpl01();

    static Stream<Arguments> intIntAndIntArrayProvider() {
        return Stream.of(
            arguments(-1, 3, new int[]{}),
            arguments(-1, 3, new int[]{1})
        );
    }

    @DisplayName("Chopping gives correct result")
    @ParameterizedTest(name = "{index} ==> {1} results in {0}")
    @MethodSource("intIntAndIntArrayProvider")
    void testChopping(int result, int search, int[] set) {
        assertEquals(result, chopper.chop(search, set));
    }

    @Test
    void seachNumber() {
        assertEquals(-1, chopper.chop(3, new int[]{}));
        assertEquals(-1, chopper.chop(3, new int[]{1}));
        assertEquals(1, chopper.chop(1, new int[]{1}));

//        assert_equal(-1, chop(3, []))
//        assert_equal(-1, chop(3, [1]))
//        assert_equal(0,  chop(1, [1]))
//        assert_equal(0,  chop(1, [1, 3, 5]))
//        assert_equal(1,  chop(3, [1, 3, 5]))
//        assert_equal(2,  chop(5, [1, 3, 5]))
//        assert_equal(-1, chop(0, [1, 3, 5]))
//        assert_equal(-1, chop(2, [1, 3, 5]))
//        assert_equal(-1, chop(4, [1, 3, 5]))
//        assert_equal(-1, chop(6, [1, 3, 5]))
//        assert_equal(0,  chop(1, [1, 3, 5, 7]))
//        assert_equal(1,  chop(3, [1, 3, 5, 7]))
//        assert_equal(2,  chop(5, [1, 3, 5, 7]))
//        assert_equal(3,  chop(7, [1, 3, 5, 7]))
//        assert_equal(-1, chop(0, [1, 3, 5, 7]))
//        assert_equal(-1, chop(2, [1, 3, 5, 7]))
//        assert_equal(-1, chop(4, [1, 3, 5, 7]))
//        assert_equal(-1, chop(6, [1, 3, 5, 7]))
//        assert_equal(-1, chop(8, [1, 3, 5, 7]))
    }
}
