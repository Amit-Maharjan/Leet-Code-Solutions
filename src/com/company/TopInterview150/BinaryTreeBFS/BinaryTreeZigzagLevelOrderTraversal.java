package com.company.TopInterview150.BinaryTreeBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int isEven = -1;
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode node = que.remove();
                if (node.left!=null) que.add(node.left);
                if (node.right!=null) que.add(node.right);
                list.add(node.val);
            }

            if (isEven>0) {
                int start = 0;
                int end = list.size()-1;
                while (start<end) {
                    int temp = list.get(start);
                    list.set(start++, list.get(end));
                    list.set(end--, temp);
                }
            }
            isEven *= -1;
            res.add(list);
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
