package main.LeetCode.easy_to_250.question206;

import main.LeetCode.ListNode;

public class Reverse_Linked_List {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tailHead = new ListNode(head.val);
        while (head.next != null) {
            ListNode current = new ListNode(head.next.val);
            current.next = tailHead;
            tailHead = current;
            head = head.next;
        }
        return tailHead;
    }

}
