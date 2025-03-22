package com.company.TopInterview150.DP.OneDimensional;

public class HouseRobber {
    public int rob(int[] nums) {
        int first = 0;
        int second = 0;
        for (int num : nums) {
            int amount = Math.max(second, first+num);
            first = second;
            second = amount;
        }
        return second;
    }
}
