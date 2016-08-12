package recursion;

import datastructures.BinaryTreeNode;

public class ValidateBst {

	/*
	 * Implement a function to check if a binary tree is a binary search tree
	 * 
	 *  CtCI 4.5
	 */
	
	private static boolean checkBstWithRange(BinaryTreeNode root, int min, int max) {
		if (root == null) return true;
		if (root.val < min || root.val > max) return false;
		return checkBstWithRange(root.left, min, root.val)
				&& checkBstWithRange(root.right, root.val + 1, max);
	}
	
	public static boolean checkBst(BinaryTreeNode root) {
		return checkBstWithRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(20);
		root.left = new BinaryTreeNode(10);
		root.right = new BinaryTreeNode(30);
		root.left.right = new BinaryTreeNode(25);
		System.out.println(checkBst(root));
	}
}
