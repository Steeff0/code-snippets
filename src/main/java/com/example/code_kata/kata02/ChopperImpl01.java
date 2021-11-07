package com.example.code_kata.kata02;

public class ChopperImpl01 implements Chopper{
    public int chop(int search, int[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == search) {
                return i;
            }
        }
        return -1;
    }
}
