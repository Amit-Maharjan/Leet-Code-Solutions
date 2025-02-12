package com.company.TopInterview150.Hashmap;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence1 {
    // Time Limit Exceeded
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (!set.contains(num-1)) {
                int length = 1;
                while (set.contains(num+length)) length++;
                res = Math.max(res, length);
            }
        }

        return res;
    }
}

/*
[100,   4,  200,    1,  3,  2]

Need to group:
100
200
1,2,3,4

How?
=> 100 : 100-1=99 is there? no so start with 100 and see 100+1 is there?
If no, res++
*/