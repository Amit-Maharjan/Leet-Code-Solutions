package com.company.TopInterview150.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        addCombination(n,k,res,new ArrayList<>(), 1);
        return res;
    }

    private void addCombination(int n, int k, List<List<Integer>> res, List<Integer> curr, int start) {
        if (curr.size()==k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i=start; i<=n; i++) {
            curr.add(i);
            addCombination(n,k,res,curr,i+1);
            curr.remove(curr.size()-1);
        }
    }
}
