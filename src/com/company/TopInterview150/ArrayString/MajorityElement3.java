package com.company.TopInterview150.ArrayString;

public class MajorityElement3 {
    public int majorityElement(int[] nums) {
        int num = nums[0];
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]==num) count++;
            else {
                count--;
                if (count==-1) {
                    num = nums[i];
                    count = 0;
                }
            }
        }
        return num;
    }
}
