package com.company.TopInterview150.Math;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n>0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
