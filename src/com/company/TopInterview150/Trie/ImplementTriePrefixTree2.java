package com.company.TopInterview150.Trie;

public class ImplementTriePrefixTree2 {
    TreeNode root;

    public ImplementTriePrefixTree2() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c-'a';
            if (curr.children[index]==null) {
                curr.children[index] = new TreeNode();
            }
            curr = curr.children[index];
        }
        curr.endNode = true;
    }

    public boolean search(String word) {
        TreeNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c-'a';
            if (curr.children[index]==null) return false;
            curr = curr.children[index];
        }
        return curr.endNode;
    }

    public boolean startsWith(String prefix) {
        TreeNode curr = root;
        for (char c : prefix.toCharArray()) {
            int index = c-'a';
            if (curr.children[index]==null) return false;
            curr = curr.children[index];
        }
        return true;
    }
}

class TreeNode {
    TreeNode[] children;
    boolean endNode;

    TreeNode() {
        children = new TreeNode[26];
        endNode = false;
    }
}