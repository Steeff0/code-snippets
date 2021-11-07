package com.example.code_kata.kata02;

public class ChopperImpl02 implements Chopper{
    public int chop(int search, int[] numbers) {
        int l = 0;
        int r = numbers.length - 1;
        return binarySearch(l, r, search, numbers);
    }

    private int binarySearch(int l, int r, int t, int[] a) {
        if (l > r) {
            return -1;
        }

        int m = Math.floorDiv((l+r),2);
        if(a[m] == t){
            return m;
        } else if (a[m] < t) {
            return binarySearch((m+1), r, t, a);
        } else {
            return binarySearch(l, (m-1), t, a);
        }
    }
}
