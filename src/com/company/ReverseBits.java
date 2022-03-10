package com.company;

public class ReverseBits {
    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        int output = reverseBits.reverseBits(43261596);
        System.out.println(output);
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int output = 0;
        int bitMask = 1;

        for (int currentLeftShiftInOutput = 31; currentLeftShiftInOutput >= 0; currentLeftShiftInOutput--) {
            // check if the rightmost bit in the input is set
            if((n & 1) == 1) {
                // it's set, so add it to the left of the output
                // note that we can use bitwise or (|) because the bitmask has a single set bit,
                // that will never overlap with another set bit in the output number
                // so there will never be carrying operations needed.
                output = output | (bitMask << currentLeftShiftInOutput);
            }

            String bits = Integer.toBinaryString(n);
            String bits2 = Integer.toBinaryString(output);

            // we've finished examining the rightmost bit of n,
            // so we can eliminate it, regardless of whether it was set or not
            n >>= 1;
        }

        return output;
    }
}
