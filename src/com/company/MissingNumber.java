package com.company;

public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        int[] nums = new int[]{3,0,1};
        int result = missingNumber.missingNumber(nums);
        System.out.println(result);
    }

    public int missingNumber(int[] nums) {
        int runningTotal = 0;

        for (int i = 1; i < nums.length + 1; i++) {
            runningTotal += i;
            runningTotal -= nums[i - 1];
        }

        return runningTotal;
    }
}
