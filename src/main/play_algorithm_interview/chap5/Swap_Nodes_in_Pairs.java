package main.play_algorithm_interview.chap5;

import main.LeetCode.ListNode;

public class Swap_Nodes_in_Pairs {

    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
            ListNode p1 = p.next;
            ListNode p2 = p1.next;
            ListNode next = p2.next;

            p2.next = p1;
            p1.next = next;
            p.next = p2;

            p = p1;
        }

        return dummy.next;
    }

}
