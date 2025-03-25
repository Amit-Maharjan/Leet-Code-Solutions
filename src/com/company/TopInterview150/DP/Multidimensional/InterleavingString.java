package com.company.TopInterview150.DP.Multidimensional;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length()) return false;

        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[s1.length()][s2.length()] = true;

        for (int i=s1.length(); i>-1; i--) {
            for (int j=s2.length(); j>-1; j--) {
                if (i<s1.length() && s3.charAt(i+j)==s1.charAt(i) && dp[i+1][j]) {
                    dp[i][j] = true;
                }

                if (j<s2.length() && s3.charAt(i+j)==s2.charAt(j) && dp[i][j+1]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[0][0];
    }
}
