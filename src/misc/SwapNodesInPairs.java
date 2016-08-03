package misc;

import datastructures.ListNode;

public class SwapNodesInPairs {
	/*
	 * Leetcode #24, Easy
	 */
	public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = null;
        ListNode q = head;
        ListNode r = head.next;
        while (r != null && q != null) {
            if (p == null) {
                head = r;
            }
            else {
                p.next = r;
            }
            q.next = r.next;
            r.next = q;
            p = q;
            q = p.next;
            r = q == null ? null : q.next;
        }
        return head;
    }
}
