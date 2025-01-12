package com.company.TopInterview150.ArrayString;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        if (size <= 2) return size;

        int pos = 2;
        for (int i=2; i<nums.length; i++) {
            if (nums[i] != nums[pos-2]) {
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }
}
