package com.company.TopInterview150.BinaryTreeGeneral;

public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return root;
        if (root.val==p.val || root.val==q.val) return root;
        if (root.left==null && root.right==null) return null;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left!=null && right!=null) return root;
        return left==null ? right : left;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
