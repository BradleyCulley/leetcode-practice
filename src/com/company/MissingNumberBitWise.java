package com.company;

public class MissingNumberBitWise {
    public static void main(String[] args) {
        MissingNumberBitWise missingNumber = new MissingNumberBitWise();
        int[] nums = new int[]{3,0,1};
        int result = missingNumber.missingNumber(nums);
        System.out.println(result);
    }

    public int missingNumber(int[] nums) {
        int runningXOrResult = 0;
        for (int i = 0; i < nums.length; i++) {
            runningXOrResult ^= nums[i];
            runningXOrResult ^= i + 1;
        }

        return runningXOrResult;
    }
}
