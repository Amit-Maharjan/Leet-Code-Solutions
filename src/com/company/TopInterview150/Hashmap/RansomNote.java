package com.company.TopInterview150.Hashmap;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct1(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<magazine.length(); i++) {
            if (map.containsKey(magazine.charAt(i))) {
                map.put(magazine.charAt(i), 1 + map.get(magazine.charAt(i)));
            } else {
                map.put(magazine.charAt(i), 1);
            }
        }

        for (int i=0; i<ransomNote.length(); i++) {
            if (map.containsKey(ransomNote.charAt(i))) {
                if (map.get(ransomNote.charAt(i)) > 1) {
                    map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
                } else {
                    map.remove(ransomNote.charAt(i));
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, 1 + map.getOrDefault(c, 0));
        }

        for (char c : ransomNote.toCharArray()) {
            if (map.getOrDefault(c, 0) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
