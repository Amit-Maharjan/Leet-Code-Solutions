package com.company.TopInterview150.ArrayString;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int pos = nums.length - 1;
        if (pos < 0) return 0;
        int element = nums[pos];
        int uniqueValue = 1;

        for (int i=pos-1; i>=0; i--) {
            if (nums[i] == element) {
                continue;
            } else {
                if (uniqueValue != 1) {
                    for (int j=i+1,k=pos; j<=i+uniqueValue; j++,k++) {
                        nums[j] = nums[k];
                    }
                }

                pos = i;
                element = nums[pos];
                uniqueValue++;
            }
        }

        for (int j=1,k=pos+1; j<uniqueValue; j++,k++) {
            nums[j] = nums[k];
        }

        return uniqueValue;
    }

    public int removeDuplicates2(int[] nums) {
        int pos = 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[pos] != nums[i]) {
                nums[pos+1] = nums[i];
                pos++;
            }
        }

        return ++pos;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();

        int[] nums = {1,1,2};
        int k = obj.removeDuplicates2(nums);
        System.out.println("k = " + k);
        for (int i = 0; i < k; i++) {
            System.out.println(nums[i]);
        }

        System.out.println("--------");

        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        k = obj.removeDuplicates2(nums);
        System.out.println("k = " + k);
        for (int i = 0; i < k; i++) {
            System.out.println(nums[i]);
        }
    }
}
