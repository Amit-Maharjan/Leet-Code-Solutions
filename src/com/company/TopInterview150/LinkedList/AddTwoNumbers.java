package com.company.TopInterview150.LinkedList;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOver = 0;
        ListNode res = new ListNode();
        ListNode out = res;
        while (l1!=null || l2!=null || carryOver>0) {
            int sum = (l1==null ? 0 : l1.val) + (l2==null ? 0 : l2.val) + carryOver;
            carryOver = sum/10;
            int val = sum%10;

            res.next = new ListNode(val);
            res = res.next;
            l1 = l1==null ? l1 : l1.next;
            l2 = l2==null ? l2 : l2.next;
        }
        return out.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
