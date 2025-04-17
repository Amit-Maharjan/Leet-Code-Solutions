package com.company.TopInterview150.DP.Multidimensional;

public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n==0) return 0;

        int[] leftProfit = new int[n];
        int[] rightProfit = new int[n];

        // Compute first transaction on left
        int leftMin = prices[0];
        for (int i=1; i<n; i++) {
            leftProfit[i] = Math.max(leftProfit[i-1], prices[i]-leftMin);
            leftMin = Math.min(leftMin, prices[i]);
        }

        // Compute second transaction on right
        int rightMax = prices[n-1];
        for (int i=n-2; i>-1; i--) {
            rightProfit[i] = Math.max(rightProfit[i+1], rightMax-prices[i]);
            rightMax = Math.max(rightMax, prices[i]);
        }

        int res = rightProfit[0];
        for (int i=1; i<n; i++) {
            res = Math.max(res, leftProfit[i-1]+rightProfit[i]);
        }

        return res;
    }
}
