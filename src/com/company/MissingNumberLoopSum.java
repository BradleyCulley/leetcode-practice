package com.company;

public class MissingNumberLoopSum {
    public static void main(String[] args) {
        MissingNumberLoopSum missingNumber = new MissingNumberLoopSum();
        int[] nums = new int[]{3,0,1};
        int result = missingNumber.missingNumber(nums);
        System.out.println(result);
    }

    public int missingNumber(int[] nums) {
        int runningTotal = 0;

        for (int i = 1; i < nums.length + 1; i++) {
            runningTotal += i;
        }
        
        for (int i = 0; i < nums.length; i++) {
            runningTotal -= nums[i];
        }

        return runningTotal;
    }
}
