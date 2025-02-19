package com.company.TopInterview150.Stack;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int result = 0;
        int currentNumber = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currentNumber = currentNumber*10 + (c-'0');
            } else if (c=='+' || c=='-') {
                result += currentNumber * sign;
                currentNumber = 0;
                sign = c=='+' ? 1 : -1;
            } else if (c=='(') {
                stack.push(result);
                stack.push(sign);
                currentNumber = 0;
                result = 0;
                sign = 1;
            } else if (c==')') {
                result = stack.pop() * (result + sign * currentNumber) + stack.pop();
                currentNumber = 0;
                sign = 1;
            }
        }
        return result + sign * currentNumber;
    }
}
