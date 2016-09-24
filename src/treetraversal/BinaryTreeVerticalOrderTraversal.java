package treetraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal {

	/*
	 * Given a binary tree, return the vertical order traversal of its nodes' values.
	 * (ie, from top to bottom, column by column).
	 * If two nodes are in the same row and column, the order should be from left to right.
	 * 
	 * Leetcode #314, Medium
	 * Facebook, Google, Snapchat
	 * 
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	// O(n), O(n)
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) return res;
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
		Queue<Integer> queue2 = new LinkedList<Integer>();
		queue1.offer(root);
		queue2.offer(0);
		int min = 0, max = 0;
		while (!queue1.isEmpty()) {
			TreeNode n = queue1.poll();
			int x = queue2.poll();
			min = x < min ? x : min;
			max = x > max ? x : max;
			List<Integer> l;
			if (map.containsKey(x)) {
				l = map.get(x);
			}
			else {
				l = new ArrayList<Integer>();
				map.put(x, l);
			}
			l.add(n.val);
			TreeNode n1 = n.left;
			if (n1 != null) {
				queue1.offer(n1);
				queue2.offer(x - 1);
			}
			n1 = n.right;
			if (n1 != null) {
				queue1.offer(n1);
				queue2.offer(x + 1);
			}
		}
		for (int i = min; i <= max; i++) {
			res.add(map.get(i));
		}
		return res;
	}

}
