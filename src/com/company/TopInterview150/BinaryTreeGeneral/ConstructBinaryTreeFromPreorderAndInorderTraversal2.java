package com.company.TopInterview150.BinaryTreeGeneral;

import java.util.Map;
import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal2 {
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, map, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder, Map<Integer, Integer> inorderMap, int inStart, int inEnd) {
        if (inStart>inEnd) return null;

        int nodeIndex = inorderMap.get(preorder[preIndex]);
        TreeNode node = new TreeNode(preorder[preIndex++]);
        node.left = build(preorder, inorderMap, inStart, nodeIndex-1);
        node.right = build(preorder, inorderMap, nodeIndex+1, inEnd);
        return node;
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
