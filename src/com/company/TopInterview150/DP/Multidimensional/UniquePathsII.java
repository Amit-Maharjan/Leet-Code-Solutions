package com.company.TopInterview150.DP.Multidimensional;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] rows = new int[n];
        rows[n-1] = 1;
        for (int i=m-1; i>-1; i--) {
            int col = 0;
            for (int j=n-1; j>-1; j--) {
                if (obstacleGrid[i][j]==0) {
                    rows[j] = rows[j] + col;
                    col = rows[j];
                } else {
                    rows[j] = 0;
                    col = 0;
                }
            }
        }
        return rows[0];
    }
}
