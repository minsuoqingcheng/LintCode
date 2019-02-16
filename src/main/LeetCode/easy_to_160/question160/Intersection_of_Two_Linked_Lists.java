package main.LeetCode.easy_to_160.question160;

import main.LeetCode.ListNode;

public class Intersection_of_Two_Linked_Lists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        ListNode currentA = headA;
        ListNode currentB = headB;
        while (lengthA < lengthB) {
            currentB = currentB.next;
            lengthB--;
        }
        while (lengthB < lengthA) {
            currentA = currentA.next;
            lengthA--;
        }
        while (currentA != null && currentB != null) {
            if (currentA == currentB) {
                return currentA;
            } else {
                currentA = currentA.next;
                currentB = currentB.next;
            }
        }
        return null;
    }

    private int getLength(ListNode node) {
        ListNode current = node;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

}
