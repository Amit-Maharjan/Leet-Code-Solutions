package com.company.TopInterview150.BinarySearch;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] small = nums1;
        int[] large = nums2;
        if (nums1.length > nums2.length) {
            small = nums2;
            large = nums1;
        }

        int l = 0;
        int r = small.length;
        int size = nums1.length + nums2.length;
        int half = size/2;
        while (true) {
            int smallMid = (l+r)/2;
            int largeMid = half - smallMid;

            int smallLeft = smallMid-1>=0 ? small[smallMid-1] : Integer.MIN_VALUE;
            int smallRight = smallMid<small.length ? small[smallMid] : Integer.MAX_VALUE;
            int largeLeft = largeMid-1>=0 ? large[largeMid-1] : Integer.MIN_VALUE;
            int largeRight = largeMid<large.length ? large[largeMid] : Integer.MAX_VALUE;

            if (smallLeft <= largeRight && largeLeft <= smallRight) {
                if (size%2==1) return Math.min(smallRight,largeRight);
                else return (double) (Math.max(smallLeft,largeLeft) + Math.min(smallRight,largeRight))/2;
            } else if (smallLeft > largeRight) {
                r = smallMid-1;
            } else l = smallMid+1;
        }
    }
}
