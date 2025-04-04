package com.company.TopInterview150.Backtracking;

import java.util.HashSet;
import java.util.Set;

public class NQueensII {
    int res = 0;

    public int totalNQueens(int n) {
        Set<Integer> colSet = new HashSet<>();
        Set<Integer> posDiagonalSet = new HashSet<>(); // row + col is constant
        Set<Integer> negDiagonalSet = new HashSet<>(); // row - col is contant
        updateResult(0, n, colSet, posDiagonalSet, negDiagonalSet);
        return res;
    }

    private void updateResult(int row, int n, Set<Integer> colSet, Set<Integer> posDiagonalSet, Set<Integer> negDiagonalSet) {
        if (row==n) {
            res++;
            return;
        }

        for (int col=0; col<n; col++) {
            if (colSet.contains(col) || posDiagonalSet.contains(row+col) || negDiagonalSet.contains(row-col)) continue;

            colSet.add(col);
            posDiagonalSet.add(row+col);
            negDiagonalSet.add(row-col);

            updateResult(row+1, n, colSet, posDiagonalSet, negDiagonalSet);

            colSet.remove(col);
            posDiagonalSet.remove(row+col);
            negDiagonalSet.remove(row-col);
        }
    }
}
