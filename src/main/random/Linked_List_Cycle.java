package main.random;

import main.random.basic.ListNode;

public class Linked_List_Cycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return true;
            } else {
                slow = slow.next;
                if (fast.next == null) {
                    return false;
                }
                fast = fast.next.next;
            }
        }
        return false;
    }

}
