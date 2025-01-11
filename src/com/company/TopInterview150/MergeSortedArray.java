package com.company.TopInterview150;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m+n-1; i > -1; i--) {
            if (m-1 > -1 && n-1 > -1) {
                if (nums1[m-1] > nums2[n-1]) {
                    nums1[i] = nums1[m-1];
                    m--;
                } else {
                    nums1[i] = nums2[n-1];
                    n--;
                }
            } else if (m-1 > -1) {
                // Do nothing
            } else if (n-1 > -1) {
                nums1[i] = nums2[n-1];
                n--;
            }
        }

        show(nums1);
    }

    public static void main(String[] args) {
        // nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;

        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(nums1, m, nums2, n);

        System.out.println("\n-----");
        // nums1 = [1], m = 1, nums2 = [], n = 0
        nums1 = new int[]{1};
        nums2 = new int[]{};
        m = 1;
        n = 0;
        mergeSortedArray.merge(nums1, m, nums2, n);

        System.out.println("\n-----");
        // nums1 = [0], m = 0, nums2 = [1], n = 1
        nums1 = new int[]{0};
        nums2 = new int[]{1};
        m = 0;
        n = 1;
        mergeSortedArray.merge(nums1, m, nums2, n);
    }

    public void show(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
