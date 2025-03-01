package com.company.TopInterview150.GraphGeneral;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int nRow = board.length;
        int nCol = board[0].length;

        // Top Row and Bottom Row
        for (int j=0; j<nCol; j++) {
            if (board[0][j]=='O') connect(board, 0,j,nRow,nCol);
            if (board[nRow-1][j]=='O') connect(board, nRow-1,j,nRow,nCol);
        }

        // Left Col and Right Col
        for (int i=0; i<nRow; i++) {
            if (board[i][0]=='O') connect(board, i,0,nRow,nCol);
            if (board[i][nCol-1]=='O') connect(board, i,nCol-1,nRow,nCol);
        }

        replace(board,nRow,nCol,'O','X');
        replace(board,nRow,nCol,'T','O');
    }

    private void connect(char[][] board, int i, int j, int nRow, int nCol) {
        if (i<0 || i>=nRow || j<0 || j>=nCol || board[i][j]!='O') return;
        board[i][j] = 'T';
        connect(board,i+1,j,nRow,nCol);
        connect(board,i-1,j,nRow,nCol);
        connect(board,i,j+1,nRow,nCol);
        connect(board,i,j-1,nRow,nCol);
    }

    private void replace(char[][] board, int nRow, int nCol, char oldVal, char newVal) {
        for (int i=0; i<nRow; i++) {
            for (int j=0; j<nCol; j++) {
                if (board[i][j]==oldVal) board[i][j] = newVal;
            }
        }
    }
}
