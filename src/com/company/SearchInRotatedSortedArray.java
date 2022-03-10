package com.company;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int[] numbers = {4,5,6,7,0,1,2};
        int result = searchInRotatedSortedArray.search(numbers, 0);

        System.out.println(result);
    }

    public int search(int[] nums, int target) {
        // perform binary search

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + ((r - l) / 2);

            // Idea:
            // First, find out which part of the rotation we're in
            // if we're in the left part of the rotation, the leftmost value will be LTE the current value
            // if we're in the right part of the rotation, the leftmost value will be more than the current value.
            // This is always true.
            int currentValue = nums[mid];

            // if we've found it
            if (currentValue == target) {
                return mid;
            }

            // if we're in the left part of the rotation
            if (currentValue >= nums[l]) {
                // if the target value is greater than the current number, search to the right
                // the same applies if it's less than the left edge of the window. That's because it means
                // that it's in the "right part" of the rotation
                if (target > currentValue || target < nums[l]) {
                    l = mid + 1;
                } else {
                    // otherwise, search to the left: it's simply between here and the left edge
                    r = mid - 1;
                }
            } else {
                // if we're in the right part of the rotation

                // if it's greater than the current value, it could be to the left or to the right.
                // In order to choose, we compare it to the left edge.
                // If it's less than the left edge, search to the right,
                // because it means it's in the "right part" of the rotation.
                // Otherwise, search to the left.
                if (target > currentValue && target < nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}
