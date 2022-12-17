package com.company;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        int result = longestCommonSubsequence.longestCommonSubsequence("abcde", "ace");
        System.out.println(result);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[0].length - 2; j >= 0; j--) {
                // TODO - fill matrix using DP logic
                if (text1.charAt(i) == text2.charAt(j)) { // the letters in the matrix are the same
                    // at this cell, so set this to the diagonal down of this, plus 1 for the match
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else { // otherwise, take the max of going down 1 and going right 1
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][0];
    }
}
