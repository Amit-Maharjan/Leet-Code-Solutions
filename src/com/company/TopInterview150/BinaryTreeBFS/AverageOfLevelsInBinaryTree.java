package com.company.TopInterview150.BinaryTreeBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            int size = que.size();
            double sum = 0;
            for (int i=0; i<size; i++) {
                TreeNode node = que.remove();
                sum += node.val;
                if (node.left!=null) que.add(node.left);
                if (node.right!=null) que.add(node.right);
            }
            res.add(sum/size);
            sum = 0;
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
