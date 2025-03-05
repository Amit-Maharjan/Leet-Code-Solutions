package com.company.TopInterview150.BitManipulation;

public class ReverseBits {
    public int reverseBits(int n) {
        int rev = 0;
        for (int i=0; i<32; i++) {
            int lastDigit = n & 1;
            rev = rev<<1;
            rev = rev | lastDigit;
            n = n>>1;
        }
        return rev;
    }
}
