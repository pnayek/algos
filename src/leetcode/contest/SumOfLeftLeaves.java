package leetcode.contest;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {
	/*
	 * Find the sum of all left leaves in a given binary tree.
	 * Example:

	    3
	   / \
	  9  20
	    /  \
	   15   7

	 There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
	 * Leetcode #404, Easy
	 */

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public int sumOfLeftLeaves(TreeNode root) {
		int sum = 0;
		if (root == null || (root.left == null && root.right == null)) return sum;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Boolean> q = new LinkedList<Boolean>(); 
		queue.offer(root);
		q.offer(false);
		while (!queue.isEmpty()) {
			TreeNode n = queue.poll();
			boolean b = q.poll();
			if (n.left == null && n.right == null) {
				if (b) sum += n.val;
				continue;
			}
			if (n.left != null) {
				queue.offer(n.left);
				q.offer(true);
			}
			if (n.right != null) {
				queue.offer(n.right);
				q.offer(false);
			}
		}
		return sum;
	}
}
