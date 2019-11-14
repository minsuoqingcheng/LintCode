package main.classify.linkedlist;

import main.classify.basic.ListNode;

public class Add_Two_Numbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + carry;
            int bit = sum % 10;
            carry = sum / 10;

            current.next = new ListNode(bit);
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //还有一个进位没有处理
        if (carry == 1) {
            current.next = new ListNode(carry);
        }
        return dummy.next;
    }

}
