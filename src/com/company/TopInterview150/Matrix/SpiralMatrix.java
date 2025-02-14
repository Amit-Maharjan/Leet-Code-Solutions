package com.company.TopInterview150.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int x = 0;
        int y = 0;
        int dx = 1;
        int dy = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<rows*cols; i++) {
            list.add(matrix[y][x]);
            matrix[y][x] = 101;

            if (!(0<=x+dx && x+dx<cols && 0<=y+dy && y+dy<rows) || matrix[y+dy][x+dx] == 101) {
                int temp = dx;
                dx = -dy;
                dy = temp;
            }

            x += dx;
            y += dy;
        }
        return list;
    }
}
