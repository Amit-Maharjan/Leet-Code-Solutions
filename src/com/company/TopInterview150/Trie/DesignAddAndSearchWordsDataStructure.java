package com.company.TopInterview150.Trie;

public class DesignAddAndSearchWordsDataStructure {
    Node root;

    public DesignAddAndSearchWordsDataStructure() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int index = c-'a';
            if (curr.children[index]==null) {
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }
        curr.endNode = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    private boolean dfs(String word, Node rootNode, int wordIndex) {
        Node curr = rootNode;
        for (int i=wordIndex; i<word.length(); i++) {
            char c = word.charAt(i);
            if (c=='.') {
                for (Node child : curr.children) {
                    if (child!=null && dfs(word, child, i+1)) return true;
                }
                return false;
            } else {
                int index = c-'a';
                if (curr.children[index]==null) return false;
                curr = curr.children[index];
            }
        }
        return curr.endNode;
    }

    class Node {
        Node[] children;
        boolean endNode;

        Node() {
            children = new Node[26];
            endNode = false;
        }
    }
}