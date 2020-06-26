package main.classify.everyday;

import main.classify.basic.ListNode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNodes {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Set<Integer> values = new HashSet<>();
        values.add(head.val);
        ListNode current = head;
        while (current.next != null) {
            if (values.contains(current.next.val)) {
                current.next = current.next.next;
            } else {
                values.add(current.next.val);
                current = current.next;
            }
        }
        return head;
    }

}
