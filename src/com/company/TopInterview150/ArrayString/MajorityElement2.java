package com.company.TopInterview150.ArrayString;

import java.util.Arrays;

public class MajorityElement2 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int num = nums[0];
        int count = 1;

        for (int i=1; i<nums.length; i++) {
            if (nums[i]==num) {
                count++;
            } else {
                if (count>nums.length/2) return num;
                num = nums[i];
                count = 1;
            }
        }

        return num;
    }
}
