package com.company.TopInterview150.BinaryTreeGeneral;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        if (root==null) return root;

        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            Node node = que.remove();
            for (int i=0; i<size-1; i++) {
                Node nextNode = que.poll();
                node.next = nextNode;

                if (node.left!=null) que.add(node.left);
                if (node.right!=null) que.add(node.right);

                node = nextNode;
            }
            node.next = null;
            if (node.left!=null) que.add(node.left);
            if (node.right!=null) que.add(node.right);
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
