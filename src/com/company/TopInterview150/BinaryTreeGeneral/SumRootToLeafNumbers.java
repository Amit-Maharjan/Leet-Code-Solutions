package com.company.TopInterview150.BinaryTreeGeneral;

public class SumRootToLeafNumbers {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        sum(root, 0);
        return sum;
    }

    private void sum(TreeNode root, int prevSum) {
        if (root==null) return;
        prevSum = prevSum*10+root.val;
        sum(root.left, prevSum);
        sum(root.right, prevSum);

        if (root.left==null && root.right==null) sum+=prevSum;
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
