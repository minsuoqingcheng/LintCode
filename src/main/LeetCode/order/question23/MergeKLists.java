package main.LeetCode.order.question23;

import java.util.*;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        if (lists == null || lists.length == 0) {
            return null;
        }
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(l -> l.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode top;
        while ((top = queue.poll()) != null) {
            current.next = top;
            current = current.next;
            if (top.next != null) {
                queue.add(top.next);
            }
        }
        return head.next;
    }


    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        else if (lists.length == 1) return lists[0];
        else return mergeKLists(Arrays.asList(lists));
    }

    private ListNode mergeKLists(List<ListNode> lists) {
        return lists.size() == 1 ? lists.get(0)
                : merge(
                        mergeKLists(lists.subList(0, lists.size()/2)),
                        mergeKLists(lists.subList(lists.size()/2, lists.size()))
                );
    }


    private ListNode merge(ListNode a, ListNode b) {
        ListNode fh = new ListNode(0), p = fh;
        while (a != null && b != null) {
            if (a.val < b.val) {
                p.next = a;
                a = a.next;
            } else {
                p.next = b;
                b = b.next;
            }
            p = p.next;
        }
        p.next = a == null ? b : a;
        return fh.next;
    }

}
