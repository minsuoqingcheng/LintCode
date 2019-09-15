package main.play_algorithm_interview.chap5;

import main.LeetCode.ListNode;

public class Delete_Node_in_Linked_List {

    public void deleteNode(ListNode node) {

        if (node == null) {
            return;
        }
        if (node.next == null) {
            node = null;
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
