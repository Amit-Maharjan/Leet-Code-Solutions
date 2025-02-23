package com.company.TopInterview150.BinaryTreeGeneral;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0 || inorder.length==0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        int rootPos =  getIndex(inorder, preorder[0]);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootPos+1), Arrays.copyOfRange(inorder, 0, rootPos));
        root.right = buildTree(Arrays.copyOfRange(preorder, rootPos+1, preorder.length), Arrays.copyOfRange(inorder, rootPos+1, inorder.length));

        return root;
    }

    private int getIndex(int[] array, int val) {
        for (int i=0; i<array.length; i++) {
            if (array[i]==val) return i;
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
