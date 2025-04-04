package com.company.TopInterview150.Backtracking;

public class NQueensII2 {
    int res = 0;

    public int totalNQueens(int n) {
        boolean[] colSet = new boolean[n];
        boolean[] posDiagonalSet = new boolean[2*n]; // row + col
        boolean[] negDiagonalSet = new boolean[2*n]; // row - col + (n - 1)
        /*
        * Why row - col + n - 1?
        * Because row - col can be negative.
        * To avoid negative indexing, shift all values by (n - 1) so the index always stays within 0 to 2n-2.
        * */
        updateResult(0, n, colSet, posDiagonalSet, negDiagonalSet);
        return res;
    }

    private void updateResult(int row, int n, boolean[] colSet, boolean[] posDiagonalSet, boolean[] negDiagonalSet) {
        if (row==n) {
            res++;
            return;
        }

        for (int col=0; col<n; col++) {
            int posIndex = row + col;
            int negIndex = row - col + (n - 1);

            if (colSet[col] || posDiagonalSet[posIndex] || negDiagonalSet[negIndex]) continue;

            colSet[col] = true;
            posDiagonalSet[posIndex] = true;
            negDiagonalSet[negIndex] = true;

            updateResult(row+1, n, colSet, posDiagonalSet, negDiagonalSet);

            colSet[col] = false;
            posDiagonalSet[posIndex] = false;
            negDiagonalSet[negIndex] = false;
        }
    }
}
