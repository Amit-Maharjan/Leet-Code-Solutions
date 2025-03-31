package com.company.TopInterview150.BinarySearch;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length-1;
        while (top<=bottom) {
            int mid = (top+bottom)/2;

            if (matrix[mid][0] <= target && matrix[mid][matrix[mid].length-1] >= target) break;

            if (matrix[mid][0] < target) {
                top = mid +1;
            } else bottom = mid - 1;
        }

        int row = (top+bottom)/2; // Mid before break;
        int left = 0;
        int right = matrix[left].length-1;
        while (left<=right) {
            int mid = (left+right)/2;

            if (matrix[row][mid] == target) return true;

            if (matrix[row][mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }
}
