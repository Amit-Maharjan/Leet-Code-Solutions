package com.company.TopInterview150.ArrayString;

public class HIndex {
    public int hIndex(int[] citations) {
        int length = citations.length;
        int[] citationExtra = new int[length + 1];
        for(int i=0; i<citations.length; i++) {
            citationExtra[Math.min(length, citations[i])]++;
        }

        int cumSum = 0;
        for (int i=citationExtra.length-1; i>-1; i--) {
            cumSum += citationExtra[i];
            if (cumSum >= i) return i;
        }
        return 0;
    }
}
