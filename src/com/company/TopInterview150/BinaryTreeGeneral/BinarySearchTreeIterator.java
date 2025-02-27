package com.company.TopInterview150.BinaryTreeGeneral;

import java.util.Stack;

public class BinarySearchTreeIterator {
    Stack<TreeNode> stack = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root) {
        stack.push(root);
        while (root.left!=null) {
            stack.push(root.left);
            root = root.left;
        }
    }

    public int next() {
        TreeNode res = stack.pop();
        if (res.right!=null) {
            TreeNode node = res.right;
            stack.push(node);
            while (node.left!=null) {
                stack.push(node.left);
                node = node.left;
            }
        }
        return res.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
