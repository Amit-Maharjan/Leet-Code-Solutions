package com.company.TopInterview150.DivideAndConquer;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return bst(nums, 0, nums.length-1);
    }

    private TreeNode bst(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = start + (end-start+1)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = bst(nums, start, mid-1);
        node.right = bst(nums, mid+1, end);
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
