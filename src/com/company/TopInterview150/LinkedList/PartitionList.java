package com.company.TopInterview150.LinkedList;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode leftStart = new ListNode();
        ListNode rightStart = new ListNode();
        ListNode leftEnd = leftStart;
        ListNode rightEnd = rightStart;
        while (head!=null) {
            if (head.val<x) {
                leftEnd.next = head;
                leftEnd = leftEnd.next;
            } else {
                rightEnd.next = head;
                rightEnd = rightEnd.next;
            }
            head = head.next;
        }
        leftEnd.next = rightStart.next;
        rightEnd.next = null;
        return leftStart.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
