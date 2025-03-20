package com.company.TopInterview150.BitManipulation;

public class ReverseBits2 {
    int[] data = new int[256];

    public ReverseBits2() {
        for (int i=0; i<256; i++) {
            data[i] = getReverseBits(i);
        }
    }

    private int getReverseBits(int n) {
        int res = 0;
        for (int i=0; i<8; i++) {
            int lastDigit = n & 1;
            n = n >> 1;
            res = res << 1;
            res = res | lastDigit;
        }
        return res;
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int first = n & 0xFF;
        int second = (n>>8) & 0xFF;
        int third = (n>>16) & 0xFF;
        int forth = n>>24 & 0xFF;

        return data[first] << 24 | data[second] << 16 | data[third] << 8 | data[forth];
    }
}
