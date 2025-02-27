package com.company.TopInterview150.BinaryTreeBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            TreeNode node = null;
            for (int i=0; i<size; i++) {
                node = que.remove();
                if (node.left!=null) que.add(node.left);
                if (node.right!=null) que.add(node.right);
            }
            res.add(node.val);
        }

        return res;
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
