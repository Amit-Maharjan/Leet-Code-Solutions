package com.company.TopInterview150.Trie;

public class ImplementTriePrefixTree2 {
    Node root;

    public ImplementTriePrefixTree2() {
        root = new Node();
    }

    public void insert(String word) {
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
        Node curr = root;
        for (char c : word.toCharArray()) {
            int index = c-'a';
            if (curr.children[index]==null) return false;
            curr = curr.children[index];
        }
        return curr.endNode;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            int index = c-'a';
            if (curr.children[index]==null) return false;
            curr = curr.children[index];
        }
        return true;
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