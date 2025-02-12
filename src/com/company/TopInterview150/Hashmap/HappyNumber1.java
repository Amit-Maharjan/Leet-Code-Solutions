package com.company.TopInterview150.Hashmap;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber1 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)) {
            set.add(n);
            n = sumOfSquare(n);
            if (n==1) return true;
        }
        return false;
    }

    private int sumOfSquare(int n) {
        int sum = 0;
        while (n>0) {
            int rem = n % 10;
            sum += rem * rem;
            n = n / 10;
        }
        return sum;
    }
}
