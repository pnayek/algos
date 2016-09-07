package treetraversal;

import datastructures.BinaryTreeNode;

public class SumRootToLeafNumbers {

	/*
	 * Given a binary tree containing digits from 0-9 only,
	 * each root-to-leaf path could represent a number.
	 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
	 * Find the total sum of all root-to-leaf numbers.
	 * For example,
	 *     1
	 *    / \
	 *   2   3
	 * The root-to-leaf path 1->2 represents the number 12.
	 * The root-to-leaf path 1->3 represents the number 13.
	 * Return the sum = 12 + 13 = 25.
	 * 
	 * Leetcode #129, Medium
	 * 
	 */

	private int sum = 0;

	// O(n), O(n)
	public int sumNumbers(BinaryTreeNode root) {
		sumNumbers(root, 0);
		return sum;
	}

	private void sumNumbers(BinaryTreeNode root, int number) {
		if (root == null) {
			sum += number;
			return;
		}
		number = number * 10 + root.val;
		if (root.left == null && root.right == null) {
			// a leaf node
			sum += number;
			return;
		}
		if (root.left != null) {
			sumNumbers(root.left, number);
		} 
		if (root.right != null) {
			sumNumbers(root.right, number);
		}
	}
}
