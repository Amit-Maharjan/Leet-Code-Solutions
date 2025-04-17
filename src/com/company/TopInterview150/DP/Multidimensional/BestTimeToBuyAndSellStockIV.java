package com.company.TopInterview150.DP.Multidimensional;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {
    int[][][] dp;

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        dp = new int[2][k+1][n]; // [State - bought or not bought][No of Transactions][Stock Day]
        for (int i=0; i<2; i++) {
            for (int j=0; j<=k; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return compute(prices, n, k, 0, false);
    }

    private int compute(int[] prices, int n, int k, int pos, boolean bought) {
        if (k==0 || pos>=n) return 0;

        int state = bought ? 1 : 0;
        if (dp[state][k][pos]!=-1) return dp[state][k][pos];

        int res = compute(prices,n,k,pos+1,bought);

        if (bought) res = Math.max(res, compute(prices,n,k-1,pos+1,false)+prices[pos]);
        else res = Math.max(res, compute(prices,n,k,pos+1,true)-prices[pos]);

        dp[state][k][pos] = res;
        return res;
    }
}
