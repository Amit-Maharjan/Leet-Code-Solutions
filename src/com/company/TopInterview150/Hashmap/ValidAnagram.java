package com.company.TopInterview150.Hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, 1 + map.getOrDefault(c,0));
        }

        for (char c : t.toCharArray()) {
            if (map.getOrDefault(c,0) <= 0) return false;
            map.put(c, map.getOrDefault(c,0) - 1);
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }
}
