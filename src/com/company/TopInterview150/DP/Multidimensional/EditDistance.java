package com.company.TopInterview150.DP.Multidimensional;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for (int i=0; i<=word1.length(); i++) {
            dp[i][word2.length()] = word1.length()-i;
        }

        for (int j=0; j<=word2.length(); j++) {
            dp[word1.length()][j] = word2.length()-j;
        }

        for (int i=word1.length()-1; i>-1; i--) {
            for (int j=word2.length()-1; j>-1; j--) {
                if (word1.charAt(i)==word2.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i+1][j], dp[i][j+1]), dp[i+1][j+1]);
                }
            }
        }

        return dp[0][0];
    }
}
