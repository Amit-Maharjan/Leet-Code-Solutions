package com.company.TopInterview150.TwoPointers;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length()==0) return true;

        int pos = 0;
        for (int i=0; i<t.length(); i++) {
            if (s.charAt(pos) == t.charAt(i)) {
                pos++;
                if (pos == s.length()) return true;
            }
        }
        return false;
    }
}
