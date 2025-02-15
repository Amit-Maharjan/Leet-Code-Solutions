package com.company.TopInterview150.Intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> input = new ArrayList<>();
        for (int i=0; i<intervals.length; i++) {
            input.add(intervals[i]);
        }
        input.add(newInterval);

        Collections.sort(input, (a, b)->Integer.compare(a[0],b[0]));

        int[] prev = input.get(0);
        List<int[]> res = new ArrayList<>();
        for (int i=1; i<input.size(); i++) {
            int[] curr=input.get(i);
            if (prev[1] >= curr[0]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                res.add(prev);
                prev = curr;
            }
        }
        res.add(prev);
        return res.toArray(new int[res.size()][]);
    }
}
