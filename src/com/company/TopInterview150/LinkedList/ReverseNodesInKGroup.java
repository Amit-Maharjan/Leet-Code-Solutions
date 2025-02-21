package com.company.TopInterview150.LinkedList;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode groupPrev = dummy;
        while (true) {
            ListNode groupLast = getLastNode(groupPrev, k);
            if (groupLast==null) break;
            ListNode groupNext = groupLast.next;

            // Reverse Group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;
            while (curr!=groupNext) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode temp = groupPrev.next;
            groupPrev.next = groupLast;
            groupPrev = temp;
        }
        return dummy.next;
    }

    private ListNode getLastNode(ListNode curr, int k) {
        while (curr!=null && k>0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
