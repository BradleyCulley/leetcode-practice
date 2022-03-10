package com.company;

public class MissingNumberGaussFormulaSum {
    public static void main(String[] args) {
        MissingNumberGaussFormulaSum missingNumber = new MissingNumberGaussFormulaSum();
        int[] nums = new int[]{3,0,1};
        int result = missingNumber.missingNumber(nums);
        System.out.println(result);
    }

    public int missingNumber(int[] nums) {
        int runningTotal = ((nums.length) * (nums.length + 1)) / 2;
        
        for (int i = 0; i < nums.length; i++) {
            runningTotal -= nums[i];
        }

        return runningTotal;
    }
}
