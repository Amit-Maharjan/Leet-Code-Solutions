package com.company.TopInterview150.Hashmap;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String element : strs) {
            int[] array = new int[26];
            for (char c : element.toCharArray()) {
                array[c-'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int num : array) {
                sb.append(num).append('#');
            }

            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(element);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String s = sort(str);
            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(str);
        }

        List<List<String>> res = new ArrayList<>();
        for(String key: map.keySet()){
            res.add(map.get(key));
        }
        return res;

        // return new ArrayList<>(map.values());
    }

    private String sort(String str) {
        char[] array = str.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
}
