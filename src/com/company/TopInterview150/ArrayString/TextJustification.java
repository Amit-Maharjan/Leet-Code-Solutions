package com.company.TopInterview150.ArrayString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int lineLength = 0;

        char[] spaces = new char[maxWidth];
        Arrays.fill(spaces, ' ');
        for (String word : words) {
            if (lineLength + line.size() + word.length() > maxWidth) {
                StringBuilder sb = new StringBuilder();
                int equalSpace = (maxWidth - lineLength) / Math.max(line.size() - 1, 1);
                int remainingSpace = (maxWidth - lineLength) % Math.max(line.size() - 1, 1);
                for (int i=0; i<line.size()-1; i++) {
                    sb.append(line.get(i));
                    sb.append(spaces,0,equalSpace);
                    if (remainingSpace-->0) sb.append(" ");
                }

                sb.append(line.get(line.size()-1));
                sb.append(spaces,0,maxWidth-sb.length());

                res.add(sb.toString());

                line.clear();
                lineLength = 0;
            }

            line.add(word);
            lineLength += word.length();
        }

        // For the lastly added word
        StringBuilder sb = new StringBuilder();
        if (line.size()>0) sb.append(line.get(0));
        for (int i=1; i<line.size(); i++) {
            sb.append(" ").append(line.get(i));
        }

        sb.append(spaces,0,Math.max(maxWidth-sb.length(),0));

        res.add(sb.toString());

        return res;
    }
}
