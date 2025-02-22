package com.company.TopInterview150.LinkedList;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode curr = head;
        ListNode last = null;
        int length = 0;
        while (curr!=null) {
            length++;
            last = curr;
            curr = curr.next;
        }

        if (length==0) return head;
        k = k%length;
        if (k==0) return head;

        curr = head;
        for (int i=0; i<length-k-1; i++) {
            curr = curr.next;
        }

        ListNode newHead = curr.next;
        curr.next = null;
        last.next = head;

        return newHead;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
