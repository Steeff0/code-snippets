package com.example.code_kata.kata02;

public class ChopperImpl05 implements Chopper {
    public int chop(int search, int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int middle = Math.floorDiv((left + right), 2);
            if (numbers[middle] < search) {
                left = middle + 1;
            } else if (numbers[middle] > search) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
