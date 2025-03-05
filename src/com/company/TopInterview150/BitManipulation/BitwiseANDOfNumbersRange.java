package com.company.TopInterview150.BitManipulation;

public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        int i=0;
        while (left!=right) {
            left = left >> 1;
            right = right >> 1;
            i++;
        }

        return left << i;
    }
}
