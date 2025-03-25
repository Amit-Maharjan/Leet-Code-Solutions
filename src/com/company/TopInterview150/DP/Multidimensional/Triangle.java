package com.company.TopInterview150.DP.Multidimensional;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n+1];
        for (int i=n-1; i>-1; i--) {
            for (int j=0; j<=i; j++) {
                int curr = triangle.get(i).get(j);
                dp[j] = curr + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}
