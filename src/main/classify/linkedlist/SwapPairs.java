package main.classify.linkedlist;

import main.classify.basic.ListNode;

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {

        ListNode empty = new ListNode(0);
        empty.next = head;
        ListNode temp = empty;

        while (temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;

            temp.next = end;
            start.next = end.next;
            end.next = start;

            temp = start;

        }

        return empty.next;
    }

}
