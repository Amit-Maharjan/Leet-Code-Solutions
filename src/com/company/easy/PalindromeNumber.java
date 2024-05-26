package com.company.easy;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        int num = x;
        if (x < 0) return false;
        int y = 0;
        while (x > 0) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        if (num == y) return true;
        else return false;
    }
}
