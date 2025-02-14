package com.company.TopInterview150.Intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;

        int start = nums[0];
        for (int i=0; i<nums.length; i++) {
            if (i < nums.length-1 && nums[i]+1 == nums[i+1]) continue;
            StringBuilder sb = new StringBuilder();
            sb.append(start);
            if (start != nums[i]) sb.append("->").append(nums[i]);
            res.add(sb.toString());
            if (i < nums.length-1) start = nums[i+1];
        }
        return res;
    }
}
