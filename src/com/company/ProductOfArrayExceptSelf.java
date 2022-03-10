package com.company;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4};

        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] products = productOfArrayExceptSelf.productExceptSelf(numbers);
        System.out.println(Arrays.toString(products));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] prefixProducts = new int[nums.length];
        int[] postfixProducts = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefixProducts[i] = nums[i];
            } else {
                prefixProducts[i] = prefixProducts[i - 1] * nums[i]; // nums[i - 1] is the prior running product
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                postfixProducts[i] = nums[nums.length - 1];
            } else {
                postfixProducts[i] = nums[i] * postfixProducts[i + 1]; // nums[i + 1] is the prior running product
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) { // if we're at the first number in the array
                nums[i] = postfixProducts[i + 1];
            } else if(i == nums.length - 1) { // if we're at the last number in the array
                nums[i] = prefixProducts[i - 1];
            } else {
                nums[i] = prefixProducts[i - 1] * postfixProducts[i + 1];
            }
        }

        return nums;
    }
}
