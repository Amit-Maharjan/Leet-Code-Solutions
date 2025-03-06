package com.company.TopInterview150.Math;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int extra = 1;
        for (int i=digits.length-1; i>-1; i--) {
            extra += digits[i];
            digits[i] = extra%10;
            extra = extra/10;
        }

        if (extra!=0) {
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = extra;
            for (int i=1; i<newDigits.length; i++) {
                newDigits[i] = digits[i-1];
            }
            return newDigits;
        }
        return digits;
    }
}
