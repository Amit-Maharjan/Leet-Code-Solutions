package com.company.TopInterview150.Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (String str : tokens) {
            if (isOperator(str)) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(getVal(a,b,str)));
            } else {
                stack.push(str);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private boolean isOperator(String str) {
        return (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"));
    }

    private int getVal(int a, int b, String op) {
        if (op.equals("+")) return a+b;
        if (op.equals("-")) return a-b;
        if (op.equals("*")) return a*b;
        return a/b;
    }
}
