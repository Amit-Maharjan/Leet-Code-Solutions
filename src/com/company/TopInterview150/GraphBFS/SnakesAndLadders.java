package com.company.TopInterview150.GraphBFS;

import java.util.*;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        reverseBoard(board, n);

        Queue<List<Integer>> que = new LinkedList<>(); // [Position, Moves]
        que.add(Arrays.asList(1,0));
        Set<Integer> visited = new HashSet<>(); // Position
        while (!que.isEmpty()) {
            List<Integer> res = que.remove();
            int position = res.get(0);
            int moves = res.get(1);

            for (int i=1; i<=6; i++) {
                int nextPosition = position + i;
                int[] rowCol = getRowCol(nextPosition, n);
                int row = rowCol[0];
                int col = rowCol[1];
                if (board[row][col] != -1) nextPosition = board[row][col];
                if (nextPosition == n*n) return moves+1;

                if (!visited.contains(nextPosition)) {
                    visited.add(nextPosition);
                    que.add(Arrays.asList(nextPosition, moves+1));
                }
            }
        }
        return -1;
    }

    private void reverseBoard(int[][] board, int n) {
        int l = 0;
        int r = n-1;
        while (l<r) {
            int[] temp = board[l];
            board[l] = board[r];
            board[r] = temp;

            l++;
            r--;
        }
    }

    private int[] getRowCol(int num, int n) {
        int row = (num-1) / n;
        int col = (num-1) % n;
        if (row%2==1) col = n - 1 - col;
        return new int[]{row,col};
    }
}
