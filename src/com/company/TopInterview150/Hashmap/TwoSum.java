package com.company.TopInterview150.Hashmap;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) return new int[]{i, map.get(diff)};
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}

/*
a + b = target
=> b = target - a
return indices

Use Map [Number : Index]
*/