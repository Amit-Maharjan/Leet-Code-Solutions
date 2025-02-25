package com.company.TopInterview150.BinaryTreeGeneral;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        index = postorder.length-1;

        return build(postorder, map, 0, inorder.length-1);
    }

    private TreeNode build(int[] postorder, Map<Integer, Integer> map, int start, int end) {
        if (start>end) return null;

        int mid = map.get(postorder[index]);
        TreeNode node = new TreeNode(postorder[index--]);
        node.right = build(postorder, map, mid+1, end);
        node.left = build(postorder, map, start, mid-1);

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
