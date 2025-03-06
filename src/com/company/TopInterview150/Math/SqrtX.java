package com.company.TopInterview150.Math;

public class SqrtX {
    public int mySqrt(int x) {
        if (x==0) return 0;

        int left = 1;
        int right = x;
        int res = 0;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (mid > x/mid) right = mid-1;
            else if (mid < x/mid) {
                left = mid+1;
                res = mid;
            } else {
                return mid;
            }
        }
        return res;
    }
}
