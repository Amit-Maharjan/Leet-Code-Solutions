package com.company.TopInterview150.Backtracking;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if(isThere(board,m,n,i,j,word,0)) return true;
            }
        }
        return false;
    }

    private boolean isThere(char[][] board, int m, int n, int i, int j, String word, int index) {
        if (index==word.length()) return true;
        if (i<0 || j<0 || i>=m || j>=n || board[i][j]!=word.charAt(index)) return false;

        char temp = board[i][j];
        board[i][j] = '#';

        boolean top = isThere(board,m,n,i-1,j,word,index+1);
        boolean bottom = isThere(board,m,n,i+1,j,word,index+1);
        boolean left = isThere(board,m,n,i,j-1,word,index+1);
        boolean right = isThere(board,m,n,i,j+1,word,index+1);

        board[i][j] = temp;

        return top || bottom || left || right;
    }
}
