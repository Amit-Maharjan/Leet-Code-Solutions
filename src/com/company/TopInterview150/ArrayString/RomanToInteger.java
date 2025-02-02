package com.company.TopInterview150.ArrayString;

public class RomanToInteger {
    public int romanToInt(String s) {
        int res = 0;
        for (int i=0; i<s.length()-1; i++) {
            int curr = getValue(s.charAt(i));
            int next = getValue(s.charAt(i+1));
            if (curr < next) {
                curr *= -1;
            }
            res += curr;
        }
        return res + getValue(s.charAt(s.length()-1));
    }

    private int getValue(char c) {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        if (c == 'M') return 1000;
        return 0;
    }

    /*
    III -   1+1+1
    IV  -   -1+5
    M CM XC IV -   1000-100+1000-10+100-1+5
    */
}
