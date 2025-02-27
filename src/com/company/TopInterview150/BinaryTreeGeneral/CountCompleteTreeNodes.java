package com.company.TopInterview150.BinaryTreeGeneral;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int left = getLeftDepth(root);
        int right = getRightDepth(root);
        if (left == right) return (int)Math.pow(2,left) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftDepth(TreeNode root) {
        int depth = 0;
        while (root!=null) {
            depth++;
            root = root.left;
        }
        return depth;
    }

    private int getRightDepth(TreeNode root) {
        int depth = 0;
        while (root!=null) {
            depth++;
            root = root.right;
        }
        return depth;
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
