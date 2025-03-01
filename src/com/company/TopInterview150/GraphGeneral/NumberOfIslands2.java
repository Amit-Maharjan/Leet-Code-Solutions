package com.company.TopInterview150.GraphGeneral;

public class NumberOfIslands2 {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j]=='1') {
                    count++;
                    connectLand(grid,i,j,m,n);
                }
            }
        }
        return count;
    }

    private void connectLand(char[][] grid, int i, int j, int m, int n) {
        if (i<0 || i>=m || j<0 || j>=n) return;
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            connectLand(grid,i+1,j,m,n);
            connectLand(grid,i-1,j,m,n);
            connectLand(grid,i,j+1,m,n);
            connectLand(grid,i,j-1,m,n);
        }
    }
}
