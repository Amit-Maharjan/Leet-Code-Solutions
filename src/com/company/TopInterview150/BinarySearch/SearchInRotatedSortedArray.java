package com.company.TopInterview150.BinarySearch;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while (l<=r) {
            int m = (l+r)/2;
            if (nums[m] == target) return m;

            // Left Portion of the Array
            if (nums[l] <= nums[m]) {
                if (target > nums[m]) {
                    l = m + 1;
                } else if (target < nums[l]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                // Right Portion of the Array
                if (target < nums[m]) {
                    r = m - 1;
                } else if (target > nums[r]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}
