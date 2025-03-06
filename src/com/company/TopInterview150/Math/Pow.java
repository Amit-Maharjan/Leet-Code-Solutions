package com.company.TopInterview150.Math;

public class Pow {
    public double myPow(double x, int n) {
        if (n==0) return 1;
        boolean isNeg = false;
        long powN = n;
        if (n<0) {
            isNeg = true;
            powN *= -1;
        }

        double ans = pow(x,powN);
        if (isNeg) ans = 1/ans;
        return ans;
    }

    private double pow(double x, long n) {
        if (n==1) return x;

        double extra = 1;
        if (n % 2 == 1) {
            extra = x;
        }
        n = n/2;
        return pow(x * x, n) * extra;
    }
}
