package com.company.TopInterview150.LinkedList;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    int size;
    Map<Integer, Node> map;
    Node lru;
    Node mru;

    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>();
        lru = new Node(0,0);
        mru = new Node(0,0);
        lru.next = mru;
        mru.prev = lru;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            updateCache(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            updateCache(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            addNodeAtEnd(node);
            if (map.size()>size) {
                map.remove(lru.next.key);
                removeNode(lru.next);
            }
        }
    }

    public void addNodeAtEnd(Node node) {
        Node leftNode = mru.prev;
        leftNode.next = node;
        node.prev = leftNode;
        node.next = mru;
        mru.prev = node;
    }

    public void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void updateCache(Node node) {
        removeNode(node);
        addNodeAtEnd(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
