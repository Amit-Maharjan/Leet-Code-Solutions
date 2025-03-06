package com.company.TopInterview150.Math;

import java.util.Map;
import java.util.HashMap;

public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        if (points.length==1) return 1;

        int res = 0;
        for (int i=0; i<points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for (int j=i+1; j<points.length; j++) {
                double slope;
                if (points[j][0] == points[i][0]) {
                    slope = Double.POSITIVE_INFINITY;
                } else {
                    slope = (double) (points[j][1] - points[i][1]) / (points[j][0] - points[i][0]);
                    if (slope==-0.0) slope = 0.0;
                }
                map.put(slope, 1 + map.getOrDefault(slope, 1));
                res = Math.max(res, map.get(slope));
            }
        }
        return res;
    }
}
