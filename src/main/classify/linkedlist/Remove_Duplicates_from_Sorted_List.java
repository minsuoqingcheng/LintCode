package main.classify.linkedlist;

import main.classify.basic.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Remove_Duplicates_from_Sorted_List {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        Set<Integer> nodes = new HashSet<>();
        nodes.add(head.val);
        while (current != null && current.next != null) {
            if (!nodes.add(current.next.val)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

}
