package com.company.TopInterview150.Hashmap;

public class HappyNumber2 {
    public boolean isHappy(int n) {
        int s = sumOfSquare(n);
        int f = sumOfSquare(sumOfSquare(n));
        while (s!=f) {
            if (f==1) return true;
            s = sumOfSquare(s);
            f = sumOfSquare(sumOfSquare(f));
        }
        return s==1;
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
