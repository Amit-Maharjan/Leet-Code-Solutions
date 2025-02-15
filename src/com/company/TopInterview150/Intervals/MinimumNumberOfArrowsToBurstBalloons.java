package com.company.TopInterview150.Intervals;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b)->Integer.compare(a[0],b[0]));
        int count = points.length;

        int[] prev = points[0];
        for (int i=1; i<points.length; i++) {
            int[] curr = points[i];
            if (prev[1] >= curr[0]) {
                count--;
                prev[0] = Math.max(prev[0], curr[0]);
                prev[1] = Math.min(prev[1], curr[1]);
            } else {
                prev = curr;
            }
        }

        return count;
    }
}
