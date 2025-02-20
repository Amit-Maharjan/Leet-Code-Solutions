package com.company.TopInterview150.LinkedList;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode();
        res.next = head;

        ListNode leftNode = res;
        for (int i=1; i<left; i++) {
            leftNode = leftNode.next;
            head = head.next;
        }

        ListNode prevNode = null;
        for (int i=0; i<right-left+1; i++) {
            ListNode temp = head.next;
            head.next = prevNode;
            prevNode = head;
            head = temp;
        }

        leftNode.next.next = head;
        leftNode.next = prevNode;

        return res.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
