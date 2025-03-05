package com.company.TopInterview150.Math;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int num = x;
        int rev = 0;
        while (num>0) {
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        return rev==x;
    }
}
