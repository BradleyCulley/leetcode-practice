package com.company;

public class FindMinInRotatedSortedArray {
    public static void main(String[] args) {
        int[] numbers = {3, 1, 2};

        FindMinInRotatedSortedArray findMinInRotatedSortedArray = new FindMinInRotatedSortedArray();
        int result = findMinInRotatedSortedArray.findMin(numbers);
        System.out.println(result);
    }

    public int findMin(int[] nums) {
        int min = nums[0];

        int a = 0;
        int b = nums.length - 1;

        while (a <= b) {
            // first, check if we're in the left part of the rotation
            // or the right part of the rotation, by checking against
            // the value of the leftmost element.
            // if we're in the left part, the current value will be
            // GTE the left edge

            int mid = a + ((b - a) / 2);
            int currentValue = nums[mid];
            min = Math.min(min, currentValue);

            int leftValue = nums[a];

            if (currentValue >= leftValue) { // we're in the left part
                // then find out how the left edge compares to the right edge
                // if the left edge is greater than the right edge, like this [2, 3, 4, 0, 1],
                // (we'd be at the value 4), then we actually need to search to the right,
                // not to the left.
                // Otherwise, we need to search to the left,
                // as with being at the value 2 here: [0, 1, 2, 3, 4]
                if(nums[a] > nums[b]) {
                    a = mid + 1;
                } else {
                    b = mid - 1;
                }
            } else { // we're in the right part
                // then this is easy, we know we need to search to the left, because,
                // for example, we're at the value 1 here: [4, 0, 1, 2, 3]
                // so, we know that the minimum is going to be to the left of the current/mid value
                b = mid - 1;
            }
        }

        return min;
    }
}
