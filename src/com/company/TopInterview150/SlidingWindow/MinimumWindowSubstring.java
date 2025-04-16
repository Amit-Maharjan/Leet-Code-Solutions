package com.company.TopInterview150.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            charCount.put(c, 1+charCount.getOrDefault(c,0));
        }

        int charSatisfied = 0;
        int charNeeded = charCount.size(); // Unique Character
        int[] minWindow = new int[]{0, Integer.MAX_VALUE};
        Map<Character, Integer> windowCharCount = new HashMap<>();
        int i = 0;
        for (int j=0; j<s.length(); j++) {
            char c = s.charAt(j);
            if (charCount.containsKey(c)) {
                windowCharCount.put(c, 1+windowCharCount.getOrDefault(c,0));
                if (windowCharCount.get(c).equals(charCount.get(c))) {
                    charSatisfied++;
                }

                while (charSatisfied==charNeeded) {
                    if (j-i < minWindow[1]-minWindow[0]) {
                        minWindow[0] = i;
                        minWindow[1] = j;
                    }

                    // Remove from left
                    char removeChar = s.charAt(i);
                    if (windowCharCount.containsKey(removeChar)) {
                        windowCharCount.put(removeChar, windowCharCount.get(removeChar)-1);
                        if (windowCharCount.get(removeChar) < charCount.get(removeChar)) charSatisfied--;
                    }

                    i++;
                }
            }
        }

        return minWindow[1]!= Integer.MAX_VALUE ? s.substring(minWindow[0], minWindow[1]+1) : "";
    }
}
