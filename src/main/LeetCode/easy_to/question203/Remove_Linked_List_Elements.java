package main.LeetCode.easy_to.question203;

import main.LeetCode.ListNode;

public class Remove_Linked_List_Elements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head;
        ListNode pre = dummy;
        while (current != null) {
            if (current.val == val) {
                pre.next = current.next;
            } else {
                pre = pre.next;
            }
            current = current.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        Remove_Linked_List_Elements test = new Remove_Linked_List_Elements();
        System.out.println(test.removeElements(node1, 1));
    }
}
