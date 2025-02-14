package com.company.TopInterview150.Matrix;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix.length-1;
        while (left < right) {
            for (int i=0; i<(right-left); i++) {
                int top = left;
                int bottom = right;

                // Store Left Top
                int temp = matrix[top][left+i];

                // Store Left Bottom
                matrix[top][left+i] = matrix[bottom-i][left];

                // Store Right Bottom
                matrix[bottom-i][left] = matrix[bottom][right-i];

                // Store Right Top
                matrix[bottom][right-i] = matrix[top+i][right];

                // Store temp
                matrix[top+i][right] = temp;
            }
            left++;
            right--;
        }
    }
}
