package com.company.TopInterview150.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        for (char c : s.toCharArray()) {
            if (c=='(' || c=='{' || c=='[') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || map.get(stack.pop()) != c) return false;
            }
        }

        return stack.isEmpty();
    }
}
