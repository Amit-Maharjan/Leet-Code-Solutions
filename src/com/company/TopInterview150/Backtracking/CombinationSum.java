package com.company.TopInterview150.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        updateResult(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    private void updateResult(int[] candidates, int target, int index, List<List<Integer>> res, List<Integer> curr) {
        if (target==0) {
            if (target==0) res.add(new ArrayList<>(curr));
            return;
        }

        if (target<0 || index >= candidates.length) return;

        curr.add(candidates[index]);
        updateResult(candidates, target-candidates[index], index, res, curr);
        curr.remove(curr.size()-1);
        updateResult(candidates, target, index+1, res, curr);
    }
}
