package com.company;

import java.util.Arrays;

public class LongestIncreasingSubsequenceBottomUp {
    public static void main(String[] args) {
        LongestIncreasingSubsequenceBottomUp longestIncreasingSubsequence = new LongestIncreasingSubsequenceBottomUp();
        int[] sequence = new int[]{10,9,2,5,3,7,101,18};
        int result = longestIncreasingSubsequence.lengthOfLIS(sequence);
        System.out.println(result);
    }

    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);

        for (int i = nums.length - 2; i >= 0; i--) {
            int numberCheckedForMemo = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                if (numberCheckedForMemo < nums[j]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]); // the trickiest part
                    // of the algorithm. The outer loop is moving backward, and at each step of the outer loops we search
                    // forward to check the max LIS in the rest of the list, for items to our right that are
                    // larger than the starting item from the outer loop.
                    // That way, we're building upon the earlier results as we go. If we find a large number
                    // at memo[j], we say the new LIS is the prior LIS plus 1: where the 1 is to count the number at memo[i].
                    // because we do this backward, we're building up the LIS from the end of the list backward.
                    // So, we won't "miss out on" any pieces of an increasing subsequence that can possibly go to the end
                    // of the list. This building up of memo[] from the end of the array leftward is the "bottom up"
                    // part of this algorithm
                }
            }
        }

        // We have the memo array, that contains the max. Now we just need the max within that array:
        int max = Integer.MIN_VALUE;
        for(int current: memo) {
            max = Math.max(max, current);
        }
        return max;
    }
}
