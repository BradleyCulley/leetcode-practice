package com.company;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int result = containerWithMostWater.maxArea(height);
        System.out.println(result);
    }

    public int maxArea(int[] height) {
        int a = 0;
        int b = height.length - 1;

        int maxArea = 0;

        while (a <= b) {
            int minSideHeight = Math.min(height[a], height[b]);
            int baseLength = b - a;

            int waterArea = minSideHeight * baseLength;

            maxArea = Math.max(maxArea, waterArea);

            // if the left pointer is greater than the right pointer, move the right pointer inward, because it's the
            // bounding factor
            if (height[a] > height[b]) {
                b--;
            } else {
                // otherwise, if the right pointer is greater than the left pointer, move the left pointer inward, because
                // it's the bounding factor. If they're equal, it doesn't matter which one we move in, so just move the left
                // one in.
                a++;
            }
        }

        return maxArea;
    }
}
