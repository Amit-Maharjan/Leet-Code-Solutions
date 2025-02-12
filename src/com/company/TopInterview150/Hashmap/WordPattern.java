package com.company.TopInterview150.Hashmap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] array = s.split(" ");
        if (array.length != pattern.length()) return false;

        Map<Character, String> pmap = new HashMap<>();
        Map<String, Character> smap = new HashMap<>();
        for (int i=0; i<array.length; i++) {
            char c = pattern.charAt(i);
            String str = array[i];
            if (pmap.containsKey(c)) {
                if (!pmap.get(c).equals(str)) return false;
            } else {
                pmap.put(c,str);
                smap.put(str,c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<array.length; i++) {
            sb.append(smap.get(array[i]));
        }
        return sb.toString().equals(pattern);
    }
}
