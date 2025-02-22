package com.company.TopInterview150.BinaryTreeGeneral;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree2 {
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.remove();
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
            depth++;
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
