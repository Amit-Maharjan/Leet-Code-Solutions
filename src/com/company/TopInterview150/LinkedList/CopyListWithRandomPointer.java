package com.company.TopInterview150.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        map.put(null, null);

        Node current = head;
        while (current!=null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;
        while (current!=null) {
            Node node = map.get(current);
            node.next = map.get(current.next);
            node.random = map.get(current.random);

            current = current.next;
        }

        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
