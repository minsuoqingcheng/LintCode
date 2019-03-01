package main.LeetCode.medium_1.question92;

import main.LeetCode.ListNode;

public class Reverse_Linked_List {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode then = start.next;     //代表要交换的元素
        for (int i = 0; i < n - m; i++) {
            start.next = then.next;     //开始元素的下一位变为交换元素的下一个
            then.next = pre.next;       //交换元素的下一个是pre的下一个
            pre.next = then;        //pre的下一个是交换元素
            then = start.next;      //交换元素变为start的后一个
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Reverse_Linked_List test = new Reverse_Linked_List();
        System.out.println(test.reverseBetween(l1, 2, 4));
    }
}
