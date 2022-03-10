package com.company;

import java.util.Arrays;

public class MoveZeroesOptimal {
    public static void main(String[] args) {
        MoveZeroesOptimal moveZeroes = new MoveZeroesOptimal();
        int[] numbers = {0, 0, 1, 0, 3, 12};
        int[] result = moveZeroes.moveZeroes(numbers);

        System.out.println(Arrays.toString(result));
    }

    public int[] moveZeroes(int[] nums) {
        // if the array is empty or has length of 1, no reordering is possible
        if (nums.length < 2) {
            return nums;
        }

        int aPointer = 0;
        int bPointer = 0;

        while (bPointer < nums.length) {
            // advance the b pointer until it hits a non-zero number
            if(nums[bPointer] == 0) {
                bPointer++;
            } else {
                /* swap the number at the a pointer and the b pointer
                 the reason there will be a zero at the a position is that the b pointer has already
                 "swept through" that section of the array, passing by all zeroes and
                 swapping all non-zero numbers to the current front of the "non-zeros section" of the array */
                int valueAtB = nums[bPointer];
                nums[bPointer] = nums[aPointer];

                nums[aPointer] = valueAtB;

                // after the swap, move the b pointer forward
                bPointer++;

                /* always advance the a pointer, since we've either seen a 0 there
                and swapped it for a non-zero number (and so need to move to the next number),
                or seen a non-zero number and need to move to the next number */
                aPointer++;
            }
        }

        return nums;
    }
}
