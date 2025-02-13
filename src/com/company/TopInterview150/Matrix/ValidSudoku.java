package com.company.TopInterview150.Matrix;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSet = new HashSet[9];
        Set<Character>[] columnSet = new HashSet[9];
        Set<Character>[] boxSet = new HashSet[9];

        for (int i=0; i<9; i++) {
            rowSet[i] = new HashSet<>();
            columnSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char value = board[i][j];
                if (value == '.') continue;

                int index = (i/3)*3 + j/3;
                if (rowSet[i].contains(value) || columnSet[j].contains(value) || boxSet[index].contains(value)) return false;

                rowSet[i].add(value);
                columnSet[j].add(value);
                boxSet[index].add(value);
            }
        }
        return true;
    }
}
