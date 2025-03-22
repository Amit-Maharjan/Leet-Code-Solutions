package com.company.TopInterview150.DP.OneDimensional;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] array = new boolean[s.length()+1];
        array[0] = true;
        for (int i=1; i<=s.length(); i++) {
            for (String str : wordDict) {
                int start = i - str.length();
                if (start >= 0 && array[start] && s.substring(start, i).equals(str)) {
                    array[i] = true;
                    break;
                }
            }
        }

        return array[s.length()];
    }
}
