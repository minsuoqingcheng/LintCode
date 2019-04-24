package main.datastruct;

import main.classify.basic.ListNode;

public class Reverse_Linked_List {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public ListNode reverseListI(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListI(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
