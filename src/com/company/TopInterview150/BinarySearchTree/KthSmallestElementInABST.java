package com.company.TopInterview150.BinarySearchTree;

import java.util.Stack;

public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (--k==0) return node.val;

            if (node.right!=null) {
                root = node.right;
                while (root!=null) {
                    stack.push(root);
                    root = root.left;
                }
            }
        }

        return -1;
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
