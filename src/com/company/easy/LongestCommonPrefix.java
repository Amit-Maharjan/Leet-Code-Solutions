package com.company.easy;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        String minLenStr = strs[0];
        if (strs.length == 1) return minLenStr;

        for (int i = 1; i < strs.length; i++){
            if (minLenStr.length() > strs[i].length()) {
                minLenStr = strs[i];
            }
        }

        String result = "";
        for (int i = 0; i < minLenStr.length(); i++) {
            Character c = minLenStr.charAt(i);
            Boolean same = false;
            for (int j = 0; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    return result;
                } else {
                    same = true;
                }
            }

            if (same) result += c;
        }

        return result;
    }
}
