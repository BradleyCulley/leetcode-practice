package com.company;

import java.util.Arrays;

public class CountBits {
    public static void main(String[] args) {
        CountBits countBits = new CountBits();
        int[] result = countBits.countBits(5);
        System.out.println(Arrays.toString(result));
    }

    public int[] countBits(int n) {
        int[] counts = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            counts[i] = count1BitsInInteger(i);
        }

        return counts;
    }

    private int count1BitsInInteger(int n) {
        int numberOf1Bits = 0;

        while (n != 0) {
            n &= n -1;
            numberOf1Bits++;
        }

        return numberOf1Bits;
    }
}
