package com.company.TopInterview150.BinaryTreeGeneral;

public class FlattenBinaryTreeToLinkedList2 {
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root==null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
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