package com.company.TopInterview150.BinarySearch;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int res = Integer.MAX_VALUE;
        while (l<=r) {
            // The portion is completely sorted
            if (nums[l] <= nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }

            int m = (l+r)/2;
            res = Math.min(res, nums[m]);
            // Left Portion
            if (nums[l] <= nums[m]) {
                l = m + 1;
            } else {
                // Right Portion
                r = m - 1;
            }
        }

        return res;
    }
}
