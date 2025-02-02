package com.company.TopInterview150.ArrayString;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        // Prefix
        output[0] = 1;
        for (int i=1; i<nums.length; i++) {
            output[i] = output[i-1] * nums[i-1];
        }

        // Suffix
        // output[nums.length-1] *= 1;
        int cumProd = 1;
        for (int i=nums.length-2; i>-1; i--) {
            cumProd *= nums[i+1];
            output[i] *= cumProd;
        }
        return output;
    }
    /*
    0   1   2   3
    [1, 2,  3,  4]

    Prefix: [1  1   2   6]
    Suffix:  [24  12   4   1]

    Output: [24 12  8   6]
    */
}
