package main.classify.everyday;

import main.classify.basic.ListNode;

public class MergeKLists {

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		return merge(lists, 0, lists.length-1);
	}


	private ListNode merge(ListNode[] lists, int low, int high) {
		if (low == high) {
			return lists[low];
		}
		int mid = low + (high - low) / 2;
		ListNode l1 = merge(lists, low, mid);
		ListNode l2 = merge(lists, mid+1, high);
		return merge2Lists(l1, l2);
	}

	private ListNode merge2Lists(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode tail = dummyHead;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				tail.next = l1;
				l1 = l1.next;
			} else {
				tail.next = l2;
				l2 = l2.next;
			}
			tail = tail.next;
		}

		tail.next = l1 == null? l2: l1;

		return dummyHead.next;
	}
}
