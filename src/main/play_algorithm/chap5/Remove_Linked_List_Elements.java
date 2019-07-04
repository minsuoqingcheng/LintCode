package main.play_algorithm.chap5;

import main.LeetCode.ListNode;

public class Remove_Linked_List_Elements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null) {
            ListNode delNode = current.next;
            if (delNode.val == val) {
                current.next = delNode.next;
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }

}
