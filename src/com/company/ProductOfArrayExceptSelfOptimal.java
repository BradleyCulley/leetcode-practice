package com.company;

import java.util.Arrays;

public class ProductOfArrayExceptSelfOptimal {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4};

        ProductOfArrayExceptSelfOptimal productOfArrayExceptSelf = new ProductOfArrayExceptSelfOptimal();
        int[] products = productOfArrayExceptSelf.productExceptSelf(numbers);
        System.out.println(Arrays.toString(products));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] = prefix;
            prefix *= nums[i];
        }

        int currentPostfixProduct = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= currentPostfixProduct;
            currentPostfixProduct *= nums[i];
        }

        return output;
    }
}
