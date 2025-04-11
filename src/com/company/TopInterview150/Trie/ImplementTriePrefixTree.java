package com.company.TopInterview150.Trie;

import java.util.HashMap;
import java.util.Map;

public class ImplementTriePrefixTree {
    Node root;

    public ImplementTriePrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            curr.childern.putIfAbsent(c, new Node());
            curr = curr.childern.get(c);
        }
        curr.endNode = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.childern.containsKey(c)) return false;
            curr = curr.childern.get(c);
        }
        return curr.endNode;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            if (!curr.childern.containsKey(c)) return false;
            curr = curr.childern.get(c);
        }
        return true;
    }
}

class Node {
    Map<Character, Node> childern = new HashMap<>();
    boolean endNode = false;
}