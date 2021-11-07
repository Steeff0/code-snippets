package com.example.code_kata.kata02;

public class ChopperImpl04 implements Chopper{
    public int chop(int search, int[] numbers) {
        return chop(search, numbers, 0, numbers.length -1);
    }

    public int chop(int search, int[] numbers, int l, int r) {
        int m = Math.floorDiv((l+r),2);
        if (l > r) {
            return -1;
        } else if (numbers[m] < search) {
            return chop(search, numbers, (m+1), r);
        } else if (numbers[m] > search){
            return chop(search, numbers, l, (m-1));
        }
        return m;
    }
}
