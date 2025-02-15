package com.company.TopInterview150.Intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval2 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int i=0; i<intervals.length; i++) {
            int[] curr = intervals[i];
            // newInterval is before curr
            if (newInterval[1]<curr[0]) {
                res.add(newInterval);
                res.addAll(getRemList(intervals,i));
                return res.toArray(new int[res.size()][]);
            } else if (newInterval[0]>curr[1]) { // newInterval is after curr
                res.add(curr);
            } else {
                newInterval[0] = Math.min(newInterval[0], curr[0]);
                newInterval[1] = Math.max(newInterval[1], curr[1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }

    private List<int[]> getRemList(int[][] intervals, int i) {
        List<int[]> res = new ArrayList<>();
        for (int j=i; j<intervals.length; j++) {
            res.add(intervals[j]);
        }
        return res;
    }
}
