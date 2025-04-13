package com.company.TopInterview150.GraphBFS;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        // Collections.addAll(wordSet, wordList);
        for (String word : wordList) {
            wordSet.add(word);
        }


        if (!wordSet.contains(endWord)) return 0;

        Queue<CurrWord> que = new LinkedList<>();
        que.add(new CurrWord(beginWord, 1));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!que.isEmpty()) {
            CurrWord currWord = que.remove();

            if (currWord.value.equals(endWord)) return currWord.steps;

            StringBuilder sb = new StringBuilder(currWord.value);
            for (int i=0; i<sb.length(); i++) {
                char temp = sb.charAt(i);
                for (char c='a'; c<='z'; c++) {
                    sb.setCharAt(i, c);
                    addToQueueIfValid(que, sb.toString(), currWord.steps+1, wordSet, visited);
                }
                sb.setCharAt(i, temp);
            }
        }
        return 0;
    }

    private void addToQueueIfValid(Queue<CurrWord> que , String word, int steps, Set<String> wordSet, Set<String> visited) {
        if (wordSet.contains(word) && !visited.contains(word)) {
            que.add(new CurrWord(word, steps));
            visited.add(word);
        }
    }

    class CurrWord {
        String value;
        int steps;

        CurrWord(String value, int steps) {
            this.value = value;
            this.steps = steps;
        }
    }
}
