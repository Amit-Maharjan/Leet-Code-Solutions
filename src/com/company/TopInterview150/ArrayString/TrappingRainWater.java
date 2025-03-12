package com.company.TopInterview150.ArrayString;

public class TrappingRainWater {
    public int trap(int[] height) {
        int sum = 0;
        int left = 0;
        int right = height.length-1;
        int maxLeft = 0;
        int maxRight = 0;
        while (left<=right) {
            if (maxLeft <= maxRight) {
                int water = maxLeft - height[left];
                if (water>0) sum += water;
                maxLeft = Math.max(maxLeft, height[left]);
                left++;
            } else {
                int water = maxRight - height[right];
                if (water>0) sum += water;
                maxRight = Math.max(maxRight, height[right]);
                right--;
            }
        }
        return sum;
    }
}
