package com.company.TopInterview150.DP.Multidimensional;

import java.util.Arrays;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rows = new int[n];
        Arrays.fill(rows, Integer.MAX_VALUE);
        rows[n-1] = 0;
        for (int i=m-1; i>-1; i--) {
            int col = Integer.MAX_VALUE;
            for (int j=n-1; j>-1; j--) {
                rows[j] = grid[i][j] + Math.min(rows[j], col);
                col = rows[j];
            }
        }
        return rows[0];
    }
}
