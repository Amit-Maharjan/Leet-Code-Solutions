package com.company.TopInterview150.BinaryTreeGeneral;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymm(root.left, root.right);
    }

    private boolean isSymm(TreeNode left, TreeNode right) {
        if (left==null && right==null) return true;
        if (left==null || right==null) return false;
        if (left.val!=right.val) return false;
        return isSymm(left.left, right.right) && isSymm(left.right, right.left);
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
