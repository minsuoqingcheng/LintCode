package main.classify.linkedlist;

import main.classify.basic.ListNode;

public class DeleteNode {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
