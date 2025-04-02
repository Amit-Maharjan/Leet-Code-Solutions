package com.company.TopInterview150.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length==1) {
            List<Integer> curr = new ArrayList<>();
            curr.add(nums[0]);
            res.add(curr);
            return res;
        }

        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            int[] remainingNums = new int[nums.length-1];
            int index = 0;
            for (int j=0; j<nums.length; j++) {
                if (i!=j) remainingNums[index++] = nums[j];
            }

            List<List<Integer>> perms = permute(remainingNums);
            for (List<Integer> p : perms) {
                p.add(num);
            }

            res.addAll(perms);
        }
        return res;
    }
}
