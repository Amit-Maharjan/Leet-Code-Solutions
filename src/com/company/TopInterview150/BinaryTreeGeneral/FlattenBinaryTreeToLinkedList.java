package com.company.TopInterview150.BinaryTreeGeneral;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root!=null) stack.push(root);

        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if(curr.right!=null) stack.push(curr.right);
            if(curr.left!=null) stack.push(curr.left);

            if (prev!=null) {
                prev.left = null;
                prev.right = curr;
            }

            prev = curr;
        }
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
