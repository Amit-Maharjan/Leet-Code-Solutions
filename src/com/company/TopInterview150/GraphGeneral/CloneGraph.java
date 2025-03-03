package com.company.TopInterview150.GraphGeneral;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node==null) return null;

        Map<Node, Node> map = new HashMap<>();
        return getCopy(map, node);
    }

    private Node getCopy(Map<Node, Node> map, Node node) {
        if (map.containsKey(node)) return map.get(node);

        Node copy = new Node(node.val);
        map.put(node, copy);
        for (int i=0; i<node.neighbors.size(); i++) {
            copy.neighbors.add(getCopy(map, node.neighbors.get(i)));
        }

        return copy;
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
