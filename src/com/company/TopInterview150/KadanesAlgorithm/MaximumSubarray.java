package com.company.TopInterview150.KadanesAlgorithm;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int currSum = 0;

        for (int num : nums) {
            if (currSum < 0) currSum = 0;

            currSum += num;
            res = Math.max(res, currSum);
        }

        return res;
    }
}
