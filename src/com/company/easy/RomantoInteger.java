package com.company.easy;

public class RomantoInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }

    public static int romanToInt(String s) {
        int number = 0;
        int endString = s.length() - 1;
        for (int i = 0; i < endString; i++) {
            if (getValue(s.charAt(i)) < getValue(s.charAt(i + 1))) {
                number -= getValue(s.charAt(i));
            } else {
                number += getValue(s.charAt(i));
            }
        }

        return number + getValue(s.charAt(endString));
    }

    public static int getValue(char c) {
        if (c == 'I') {
            return 1;
        } else if (c == 'V') {
            return 5;
        } else if (c == 'X') {
            return 10;
        } else if (c == 'L') {
            return 50;
        } else if (c == 'C') {
            return 100;
        } else if (c == 'D') {
            return 500;
        } else if (c == 'M')
            return 1000;
        else
            return 0;
    }
}
