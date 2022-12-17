package com.company;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        int[] sequence = new int[]{10,9,2,5,3,7,101,18};
        int result = longestIncreasingSubsequence.lengthOfLIS(sequence);
        System.out.println(result);
    }

    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length];
        int lengthOfLIS = findLengthOfLIS(nums, 0, Integer.MIN_VALUE, memo);
        return lengthOfLIS;
    }

    private int findLengthOfLIS(int[] nums, int currentIndex, int currentMaxValue, int[] memo) {
        if (currentIndex == nums.length) {
            return 0;
        }

        if (memo[currentIndex] > 0) {
            return memo[currentIndex];
        }

        int includedMax = 0;

        if (nums[currentIndex] > currentMaxValue) { // if we're continuing an uptrend
            includedMax = 1 + findLengthOfLIS(nums, currentIndex + 1, nums[currentIndex], memo); // note that we
            // pass in the current value in the array as the new max that must be beaten
        }

        int excludeMax = findLengthOfLIS(nums, currentIndex + 1, currentMaxValue, memo);

        memo[currentIndex] = Math.max(memo[currentIndex], Math.max(includedMax, excludeMax));

        return memo[currentIndex];
    }
}
