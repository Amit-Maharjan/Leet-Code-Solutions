package com.company.TopInterview150.DivideAndConquer;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null) return head;

        ListNode middleNode = getMiddleNode(head);
        ListNode nextNode = middleNode.next;
        middleNode.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(nextNode);

        return merge(left,right);
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode();
        ListNode dummy = head;
        while (left!=null && right!=null) {
            if (left.val < right.val) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }

        if (left!=null) {
            head.next = left;
        }
        if (right!=null) {
            head.next = right;
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
