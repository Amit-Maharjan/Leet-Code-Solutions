package com.company.TopInterview150.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        updateResult(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void updateResult(int n, int open, int close, StringBuilder sb, List<String> res) {
        if (open==n && close==n) {
            res.add(sb.toString());
            return;
        }

        if (open<n) {
            sb.append('(');
            updateResult(n, open+1, close, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }

        if (close<open) {
            sb.append(')');
            updateResult(n, open, close+1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
