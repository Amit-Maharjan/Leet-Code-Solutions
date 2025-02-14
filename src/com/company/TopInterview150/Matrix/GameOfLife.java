package com.company.TopInterview150.Matrix;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int count = countLiveNeighbors(i,j, board, m, n);
                if (board[i][j] == 1 && (count == 2 || count == 3)) {
                    board[i][j] = 3;
                } else if (board[i][j] == 0 && count ==3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2 || board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int countLiveNeighbors(int i, int j, int[][] board, int m, int n) {
        int left = (j-1) > 0 ? j-1 : 0;
        int right = (j+1) < n-1 ? j+1 : n-1;
        int top = (i-1) > 0 ? i-1 : 0;
        int bottom = (i+1) < m-1 ? i+1 : m-1;

        int sum = 0;
        for (int k=top; k<=bottom; k++) {
            for (int l=left; l<=right; l++){
                if (k==i && l==j) continue;
                if (board[k][l] == 1 || board[k][l] == 3) {
                    sum++;
                }
            }
        }
        return sum;

        // int sum = 0;
        // for (int k=i-1; k<i+2; k++) {
        //     for (int l=j-1; l<j+2; l++) {
        //         if ((k==i && l==j) || k<0 || l<0 || k==m || l==n) continue;
        //         if (board[k][l] == 1 || board[k][l] == 3) {
        //             sum++;
        //         }
        //     }
        // }
        // return sum;
    }
}

/*
Before  After   -   Mapping
0       0       -   0
1       0       -   1
0       1       -   2
1       1       -   3

countLiveNeighbors:
1   -  <2 -   0
1   -   =2,3    -   1
1   -   >3  -   0
0   -   =3  -   1
*/
