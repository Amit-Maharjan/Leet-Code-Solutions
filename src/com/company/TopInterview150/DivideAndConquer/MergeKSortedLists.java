package com.company.TopInterview150.DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) return null;

        while (lists.length>1) {
            List<ListNode> temp = new ArrayList<>();
            for (int i=0; i<lists.length; i+=2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i+1) < lists.length ? lists[i+1] : null;
                temp.add(mergeList(l1, l2));
            }
            lists = temp.toArray(new ListNode[0]);
        }
        return lists[0];
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (l1!=null && l2!=null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1!=null) curr.next = l1;
        if (l2!=null) curr.next = l2;
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
