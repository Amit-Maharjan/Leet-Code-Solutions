package com.company.TopInterview150.Hashmap;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> smap = new HashMap<>();
        Map<Character, Character> tmap = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            if (tmap.containsKey(t.charAt(i))) {
                if (tmap.get(t.charAt(i)) != s.charAt(i)) return false;
            } else {
                smap.put(s.charAt(i), t.charAt(i));
                tmap.put(t.charAt(i), s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(smap.get(c));
        }

        return sb.toString().equals(t);
    }
}
