package misc;

import datastructures.ListNode;

public class MergeTwoSortedLists {
	/*
	 * Leetcode #21, Easy
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curr = null;
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        while (curr1 != null && curr2 != null) {
            ListNode l;
            if (curr1.val <= curr2.val) {
                l = new ListNode(curr1.val);
                curr1 = curr1.next;
            }
            else {
                l = new ListNode(curr2.val);
                curr2 = curr2.next;
            }
            if (head == null) {
                head = l;
            }
            else {
                curr.next = l;
            }
            curr = l;
        }
        if (curr1 == null) {
            // copy rest of l2
            while (curr2 != null) {
                ListNode l = new ListNode(curr2.val);
                curr2 = curr2.next;
                if (head == null) {
                    head = l;
                }
                else {
                    curr.next = l;
                }
                curr = l;
            }
        }
        if (curr2 == null) {
            // copy rest of l1
            while (curr1 != null) {
                ListNode l = new ListNode(curr1.val);
                curr1 = curr1.next;
                if (head == null) {
                    head = l;
                }
                else {
                    curr.next = l;
                }
                curr = l;
            }
        }
        return head;
    }
}
