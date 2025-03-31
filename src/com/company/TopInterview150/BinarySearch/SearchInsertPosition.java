package com.company.TopInterview150.BinarySearch;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int res = 0;
        while (l<=r) {
            int m = l + (r-l)/2;
            if (nums[m] < target) {
                l = m+1;
                res = l;
            } else r = m-1;
        }
        return res;
    }
}
