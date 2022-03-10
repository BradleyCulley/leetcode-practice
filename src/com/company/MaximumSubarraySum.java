package com.company;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        int[] ints = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaximumSubarraySum maximumSubarraySum = new MaximumSubarraySum();
        int result = maximumSubarraySum.maxSubArray(ints);
        System.out.println(result);
    }

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentMaxSum = maxSum;

        for (int i = 1; i < nums.length; i++) {
            currentMaxSum = Math.max(currentMaxSum + nums[i], nums[i]);

            maxSum = Math.max(maxSum, currentMaxSum);
        }

        return maxSum;
    }
}
