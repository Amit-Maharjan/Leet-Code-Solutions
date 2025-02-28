package com.company.TopInterview150.BinarySearchTree;

public class MinimumAbsoluteDifferenceInBST {
    int res = Integer.MAX_VALUE;
    TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root==null) return;

        dfs(root.left);
        if (prev!=null) {
            res = Math.min(res, root.val-prev.val);
        }
        prev = root;
        dfs(root.right);
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
