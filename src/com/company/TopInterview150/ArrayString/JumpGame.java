package com.company.TopInterview150.ArrayString;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int goalPos = nums.length - 1;
        for (int i = goalPos-1; i>=0; i--) {
            if (i+nums[i] >= goalPos) goalPos = i;
        }
        return goalPos == 0;
    }
}
