package com.company.TopInterview150.ArrayString;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows==1 || numRows >= s.length()) return s;

        List<List<Character>> list = new ArrayList<>();
        for (int i=0; i<numRows; i++) {
            list.add(new ArrayList<>());
        }

        int pos = 0;
        int increment = 1;
        for (int i=0; i<s.length(); i++) {
            list.get(pos).add(s.charAt(i));
            pos += increment;
            if (pos==numRows-1 || pos==0) increment *= -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<list.size(); i++) {
            for (int j=0; j<list.get(i).size(); j++) {
                sb.append(list.get(i).get(j));
            }
        }
        return sb.toString();
    }
}
