package com.company.TopInterview150.ArrayString;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        for (int i=0; i<gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }

        if (gasSum < costSum) return -1;

        int diff = 0;
        int res = 0;
        for (int i=0; i<gas.length; i++) {
            diff += gas[i] - cost[i];
            if (diff < 0) {
                res = i+1;
                diff = 0;
            }
        }
        return res;
    }

    /*
            0   1   2   3   4
    Gas    [1,  2,  3,  4,  5]
    Cost    [3, 4,  5,  1,  2]

            0   1   2   3   4
    Diff    [-2 -2  -2  3   3]
                        i
    */
}
