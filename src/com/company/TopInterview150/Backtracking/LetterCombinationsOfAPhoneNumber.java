package com.company.TopInterview150.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length()==0) return res;

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        generateCombination(digits, 0, new StringBuilder(), res, map);
        return res;
    }

    private void generateCombination(String digits, int i, StringBuilder sb, List<String> res, Map<Character, String> map) {
        if (i==digits.length()) {
            res.add(sb.toString());
            return;
        }

        for (char c : map.get(digits.charAt(i)).toCharArray()) {
            sb.append(c);
            generateCombination(digits, i+1, sb, res, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
