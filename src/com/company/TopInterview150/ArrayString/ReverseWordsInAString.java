package com.company.TopInterview150.ArrayString;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] array = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=array.length-1; i>-1; i--) {
            if (array[i] != "") {
                sb.append(array[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
