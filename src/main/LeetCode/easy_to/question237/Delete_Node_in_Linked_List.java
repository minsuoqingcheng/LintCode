package main.LeetCode.easy_to.question237;

import main.LeetCode.ListNode;

public class Delete_Node_in_Linked_List {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
