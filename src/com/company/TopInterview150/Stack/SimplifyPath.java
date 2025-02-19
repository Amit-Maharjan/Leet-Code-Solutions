package com.company.TopInterview150.Stack;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] array = path.split("/");
        for (String str : array) {
            if (str.equals("") || str.equals(".")) continue;
            if (str.equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            } else {
                stack.push(str);
            }
        }

        Stack<String> stackCopy = new Stack<>();
        while(!stack.isEmpty()) {
            stackCopy.push(stack.pop());
            stackCopy.push("/");
        }

        if (stackCopy.isEmpty()) stackCopy.push("/");

        StringBuilder sb = new StringBuilder();
        while(!stackCopy.isEmpty()) {
            sb.append(stackCopy.pop());
        }

        return sb.toString();
    }
}
