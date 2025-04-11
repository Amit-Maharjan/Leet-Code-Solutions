package com.company.TopInterview150.KadanesAlgorithm;

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int globalMax = nums[0];
        int globalMin = nums[0];
        int currMax = 0;
        int currMin = 0;
        int total = 0;

        for (int num : nums) {
            currMax = Math.max(currMax+num, num);
            currMin = Math.min(currMin+num, num);

            globalMax = Math.max(globalMax, currMax);
            globalMin = Math.min(globalMin, currMin);

            total += num;
        }

        if (globalMax > 0) return Math.max(globalMax, total-globalMin);
        else return globalMax;
    }
}
