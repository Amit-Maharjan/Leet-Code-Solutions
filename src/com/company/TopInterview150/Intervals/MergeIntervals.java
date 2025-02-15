package com.company.TopInterview150.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        List<int[]> res = new ArrayList<>();
        int[] previous = intervals[0];
        for (int i=1; i<intervals.length; i++) {
            int[] current = intervals[i];
            if (previous[1] >= current[0]) {
                previous[1] = Math.max(previous[1], current[1]);
            } else {
                res.add(previous);
                previous = current;
            }
        }

        res.add(previous);
        return res.toArray(new int[res.size()][]);
    }
}
