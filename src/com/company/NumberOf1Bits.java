package com.company;

public class NumberOf1Bits {
    public static void main(String[] args) {
        NumberOf1Bits numberOf1Bits = new NumberOf1Bits();
        int output = numberOf1Bits.hammingWeight(-3);
        System.out.println(output);
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bitMask = 1;

        int numberOf1Bits = 0;

        while (bitMask <= n) {
            if ((bitMask & n) != 0) {
                numberOf1Bits++;
            }

            bitMask <<= 1;
        }

        return numberOf1Bits;
    }
}
