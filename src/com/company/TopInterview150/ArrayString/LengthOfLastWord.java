package com.company.TopInterview150.ArrayString;

public class LengthOfLastWord {
    public int lengthOfLastWord1(String s) {
        int length = 0;
        s = s.trim();
        for (int i=0; i<s.length(); i++) {
            length++;
            if (s.charAt(i)==' ') length=0;
        }
        return length;
    }

    public int lengthOfLastWord2(String s) {
        String[] arr = s.split(" ");
        return arr[arr.length-1].length();
    }
}
