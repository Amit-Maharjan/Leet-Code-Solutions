package com.company.TopInterview150.ArrayString;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int pos = nums.length - 1;

        for (int i=0; i<=pos; i++) {
            while (pos > -1 && nums[pos] == val) {
                pos--;
            }

            if (i<=pos && nums[i] == val) {
                nums[pos] += nums[i];
                nums[i] = nums[pos] - nums[i];
                pos--;
            }
        }
        return ++pos;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;

        RemoveElement removeElement = new RemoveElement();
        int k = removeElement.removeElement(nums, val);
        System.out.println("k = " + k);

        for (int i = 0; i < k; i++) {
            System.out.println(nums[i]);
        }

        System.out.println("--------");

        nums = new int[]{0,1,2,2,3,0,4,2};
        val = 2;

        k = removeElement.removeElement(nums, val);
        System.out.println("k = " + k);

        for (int i = 0; i < k; i++) {
            System.out.println(nums[i]);
        }
    }
}
