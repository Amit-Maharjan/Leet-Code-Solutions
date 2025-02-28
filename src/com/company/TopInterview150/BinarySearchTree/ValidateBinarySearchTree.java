package com.company.TopInterview150.BinarySearchTree;

public class ValidateBinarySearchTree {
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;

        boolean res = isValidBST(root.left);
        if (prev!=null && prev.val>=root.val) return false;
        prev = root;
        return res && isValidBST(root.right);
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
