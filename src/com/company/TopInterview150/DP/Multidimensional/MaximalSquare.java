package com.company.TopInterview150.DP.Multidimensional;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] squareLength = new int[m+1][n+1];
        int res = 0;
        for (int i=m-1; i>-1; i--) {
            for (int j=n-1; j>-1; j--) {
                if (matrix[i][j]=='1') {
                    squareLength[i][j] = 1 + Math.min(Math.min(squareLength[i+1][j], squareLength[i][j+1]), squareLength[i+1][j+1]);
                    res = Math.max(res, squareLength[i][j]);
                }
            }
        }

        return res*res;
    }
}
