package misc;

import datastructures.ListNode;

public class LinkedListCycle {
	/*
	 * Leetcode #141, Easy
	 */
	public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode p = head;
        ListNode p2 = head.next;
        while (p != null && p2 != null) {
            p = p.next;
            if (p2.next != null) {
                p2 = p2.next.next;
            }
            else {
                p2 = p2.next;
            }
            if (p == p2) {
                return true;
            }
        }
        return false;
    }
}
