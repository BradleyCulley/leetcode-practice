package com.company;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] numbers = {0, 1, 0, 3, 12};
        int[] result = moveZeroes.moveZeroes(numbers);

        System.out.println(Arrays.toString(result));
    }

    public int[] moveZeroes(int[] nums) {
        int aPointer = 0;
        int bPointer = nums.length - 1;

        while (aPointer <= bPointer) {
            while (nums[bPointer] == 0) {
                bPointer--;
            }

            // swap the number at a pointer and b pointer, if there's a zero at the a position
            if (nums[aPointer] == 0) {
                int valueAtB = nums[bPointer];
                nums[bPointer] = nums[aPointer];

                nums[aPointer] = valueAtB;

                // after the swap, move the b pointer inward
                bPointer--;
            }

            // always advance the a pointer, since we've either seen a 0 there and swapped it,
            // or seen a non-zero number and need to move to the next number
            aPointer++;
        }

        return nums;
    }
}
