package com.company.TopInterview150.BinarySearch;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int left = getIndexBinarySearch(nums, target, true);
        int right = getIndexBinarySearch(nums, target, false);
        return new int[] {left, right};
    }

    private int getIndexBinarySearch(int[] nums, int target, boolean getLeftIndex) {
        int l = 0;
        int r = nums.length-1;
        int res = -1;
        while (l<=r) {
            int m = (l + r) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                res = m;
                if (getLeftIndex) r = m - 1;
                else l = m + 1;
            }
        }
        return res;
    }
}
