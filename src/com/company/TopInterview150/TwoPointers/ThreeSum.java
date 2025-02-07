package com.company.TopInterview150.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (i>0 && nums[i]==nums[i-1]) continue;

            int j = i+1;
            int k = nums.length-1;
            while(j<k) {
                if (nums[i]+nums[j]+nums[k] == 0) {
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    while(nums[j]==nums[j-1] && j<k) {
                        j++;
                    }
                } else if (nums[i]+nums[j]+nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return list;
    }
}
