package com.company;

public class LongestIncreasingSubsequenceNonMemoized {
    public static void main(String[] args) {
        LongestIncreasingSubsequenceNonMemoized longestIncreasingSubsequence = new LongestIncreasingSubsequenceNonMemoized();
        int[] sequence = new int[]{10,9,2,5,3,7,101,18};
        int result = longestIncreasingSubsequence.lengthOfLIS(sequence);
        System.out.println(result);
    }

    public int lengthOfLIS(int[] nums) {
        return findLengthOfLIS(nums, 0, Integer.MIN_VALUE);
    }

    private int findLengthOfLIS(int[] nums, int currentIndex, int currentMaxValue) {
        if (currentIndex == nums.length) {
            return 0;
        }

        int includedMax = 0;

        if (nums[currentIndex] > currentMaxValue) { // if we're continuing an uptrend
            includedMax = 1 + findLengthOfLIS(nums, currentIndex + 1, nums[currentIndex]); // note that we
            // pass in the current value in the array as the new max that must be beaten
        }

        int excludeMax = findLengthOfLIS(nums, currentIndex + 1, currentMaxValue);

        return Math.max(includedMax, excludeMax);
    }
}
