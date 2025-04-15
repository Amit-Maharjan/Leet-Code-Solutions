package com.company.TopInterview150.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        int wordLength = words[0].length();
        int wordCount = words.length;
        int stringSize = s.length();

        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, 1+wordFreq.getOrDefault(word, 0));
        }

        for (int offset=0; offset<wordLength; offset++) {
            Map<String, Integer> tempFreq = new HashMap<>();
            int start = offset;
            int count = 0;
            for (int end=offset; end<=stringSize-wordLength; end+=wordLength) {
                String currWord = s.substring(end, end+wordLength);
                if (wordFreq.containsKey(currWord)) {
                    tempFreq.put(currWord, 1+tempFreq.getOrDefault(currWord,0));
                    count++;

                    while (tempFreq.get(currWord)>wordFreq.get(currWord)) {
                        String removeWord = s.substring(start, start+wordLength);
                        tempFreq.put(removeWord, tempFreq.get(removeWord)-1);
                        start+=wordLength;
                        count--;
                    }

                    if (count==wordCount) res.add(start);
                } else {
                    // Reset
                    count = 0;
                    start = end + wordLength;
                    tempFreq.clear();
                }
            }
        }
        return res;
    }
}
