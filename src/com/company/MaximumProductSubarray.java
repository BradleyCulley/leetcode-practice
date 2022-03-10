package com.company;

import java.util.Arrays;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int[] numbers = new int[]{2,3,-2,4};
        int result = maximumProductSubarray.maxProduct(numbers);
        System.out.println(result);
    }

    public int maxProduct(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();

        int currentMax = 1;
        int currentMin = 1;

        for (int num : nums) {
            int lastCurrentMax = currentMax;
            currentMax = Math.max(Math.max(currentMax * num, currentMin * num), num);
            currentMin = Math.min(Math.min(lastCurrentMax * num, currentMin * num), num);

            max = Math.max(max, currentMax);
        }

        return max;
    }
}
