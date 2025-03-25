package com.company.TopInterview150.DP.Multidimensional;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String res = "";
        int resLen = 0;
        for (int i=0; i<s.length(); i++) {
            // For Odd: Like in Example 1
            int l = i;
            int r = i;
            while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
                if (resLen<(r-l+1)) {
                    res = s.substring(l,r+1);
                    resLen = r-l+1;
                }
                l--;
                r++;
            }

            // For Even: Like in Example 2
            l = i;
            r = i+1;
            while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
                if (resLen<(r-l+1)) {
                    res = s.substring(l,r+1);
                    resLen = r-l+1;
                }
                l--;
                r++;
            }
        }
        return res;
    }
}
