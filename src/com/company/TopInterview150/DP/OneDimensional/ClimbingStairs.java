package com.company.TopInterview150.DP.OneDimensional;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int first = 1;
        int second = 1;
        for (int i=n-2; i>-1; i--) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }
}
