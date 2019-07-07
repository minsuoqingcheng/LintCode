package main.play_algorithm.chap5;

import main.LeetCode.ListNode;

public class Remove_Nth_Node_From_End_of_List {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy;
        ListNode q = dummy;
        for (int i = 0; i <= n; i++) {
            q = q.next;
        }

        while (q != null) {
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next;
        return dummy.next;
    }
}
