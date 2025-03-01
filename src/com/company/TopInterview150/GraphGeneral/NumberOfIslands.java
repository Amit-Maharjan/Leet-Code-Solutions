package com.company.TopInterview150.GraphGeneral;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int island = 0;
        int nRows = grid.length;
        int nCols = grid[0].length;
        Set<String> visited = new HashSet<>();

        for (int r=0; r<nRows; r++) {
            for (int c=0; c<nCols; c++) {
                if (grid[r][c]=='1' && !visited.contains(r+","+c)) {
                    island++;
                    visited.add(r+","+c);
                    bfs(grid, nRows, nCols, r, c, visited);
                }
            }
        }

        return island;
    }

    private void bfs(char[][] grid, int nRows, int nCols, int r, int c, Set<String> visited) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{r,c});
        int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!que.isEmpty()) {
            int[] data = que.remove();
            for (int i=0; i<dir.length; i++) {
                int nr = data[0] + dir[i][0];
                int nc = data[1] + dir[i][1];
                if (nr>=0 && nr<nRows && nc>=0 && nc<nCols && grid[nr][nc]=='1' && !visited.contains(nr+","+nc)) {
                    que.add(new int[]{nr,nc});
                    visited.add(nr+","+nc);
                }
            }
        }
    }
}
