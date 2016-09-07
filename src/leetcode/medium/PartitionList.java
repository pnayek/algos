package leetcode.medium;

import datastructures.ListNode;

public class PartitionList {
	/*
	 * Given a linked list and a value x, partition it such that
	 * all nodes less than x come before nodes greater than or equal to x.
	 * You should preserve the original relative order of the nodes in each of the two partitions.
	 * For example,
	 * Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
	 * 
	 * Leetcode #86, Medium
	 */
	private ListNode add(ListNode p, int v) {
        ListNode q = new ListNode(v);
        if (p != null) {
            p.next = q;
        }
        return q;
    }
    
	// O(n), O(n)
    public ListNode partition(ListNode head, int x) {
        ListNode h1 = null;
        ListNode h2 = null;
        ListNode p1 = null;
        ListNode p2 = null;
        ListNode p = head;
        
        while (p != null) {
            if (p.val < x) {
                p1 = add(p1, p.val);
                if (h1 == null) h1 = p1;
            }
            else {
                p2 = add(p2, p.val);
                if (h2 == null) h2 = p2;
            }
            p = p.next;
        }
        // combine lists 1 and 2
        if (h1 == null) return h2;
        p1.next = h2;
        return h1;
    }
}
