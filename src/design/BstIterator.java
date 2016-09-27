package design;

import java.util.Stack;

public class BstIterator {
	/*
	 * Implement an iterator over a binary search tree (BST).
	 * Your iterator will be initialized with the root node of a BST.
	 * Calling next() will return the next smallest number in the BST.
	 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
	 * 
	 * Leetcode #173, Medium
	 * Facebook, Google, LinkedIn, Microsoft
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	Stack<Object> stack;

	public BstIterator(TreeNode root) {
		stack = new Stack<Object>();
		if (root == null) return;
		stack.push(root);
		while (stack.peek() instanceof TreeNode) {
			TreeNode n = (TreeNode) stack.pop();
			if (n.right != null) stack.push(n.right);
			stack.push(n.val);
			if (n.left != null) stack.push(n.left);
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		while (stack.peek() instanceof TreeNode) {
			TreeNode n = (TreeNode) stack.pop();
			if (n.right != null) stack.push(n.right);
			stack.push(n.val);
			if (n.left != null) stack.push(n.left);
		}
		return (Integer) stack.pop();
	}

	/*
	 * Your BSTIterator will be called like this:
	 * BSTIterator i = new BSTIterator(root);
	 * while (i.hasNext()) v[f()] = i.next();
    */
}
