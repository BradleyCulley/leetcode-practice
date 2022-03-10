package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] ints = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum.threeSum(ints);
        System.out.println(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];

            /* If this is the same "current number" we just saw, we must skip it, because otherwise
             the remainder of the array will of course be the same: so if there's a triplet for this case
             it would get counted twice if we don't do this check */
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            /* Go out and search the rest of the array for a pair of numbers that, when added to
            currentNumber, sum to 0.
            Do that by putting pointers: 1. right after the current number, and 2. the end of the array.
            Setting up the pointers that way makes it so that we can easily leverage the fact that the array is sorted. */
            int aPointer = i + 1;
            int bPointer = nums.length - 1;

            while (aPointer < bPointer) {
                if (nums[aPointer] + nums[bPointer] + currentNumber == 0) {
                    List<Integer> triplet = List.of(currentNumber, nums[aPointer], nums[bPointer]);
                    triplets.add(triplet);

                    /* Advance the left pointer, since that number has been used already,
                     and continue to do so while the number at the left pointer is the same number.
                     The key here is that there can be multiple triplets that use currentNumber.
                     In fact, the array for the first example test case is such an array */
                    do {
                        aPointer++;
                    } while(nums[aPointer] == nums[aPointer - 1] && aPointer < bPointer);
                } else if(nums[aPointer] + nums[bPointer] + currentNumber > 0) {
                    bPointer--;
                } else {
                    aPointer++;
                }
            }
        }

        return triplets;
    }
}
