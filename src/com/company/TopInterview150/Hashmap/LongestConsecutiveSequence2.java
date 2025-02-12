package com.company.TopInterview150.Hashmap;

import java.util.Arrays;

public class LongestConsecutiveSequence2 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int res = 0;
        int length = 1;
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] + 1 == nums[i+1]) {
                length++;
            } else if (nums[i] == nums[i+1]){
                continue;
            } else {
                res = Math.max(res, length);
                length = 1;
            }
        }
        return Math.max(res, length);
    }
}
