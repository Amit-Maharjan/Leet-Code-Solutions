package com.company.TopInterview150.TwoPointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^0-9a-z]","");
        int left=0;
        int right=s.length()-1;
        while(left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
