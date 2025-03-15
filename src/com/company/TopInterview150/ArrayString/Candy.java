package com.company.TopInterview150.ArrayString;

public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] numberOfCandy = new int[n];

        int prev = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            if (prev < ratings[i]) {
                numberOfCandy[i] = numberOfCandy[i-1] + 1;
            } else {
                numberOfCandy[i] = 1;
            }
            prev = ratings[i];
        }

        prev = Integer.MAX_VALUE;
        for (int i=n-1; i>-1; i--) {
            if (prev < ratings[i]) {
                numberOfCandy[i] = Math.max(numberOfCandy[i], numberOfCandy[i+1]+1);
            }
            prev = ratings[i];
        }

        int sum=0;
        for (int i=0; i<n; i++) {
            sum += numberOfCandy[i];
        }

        return sum;
    }
}
