package datastructures;

import java.util.List;

import treetraversal.BinaryTreeTraversal;

public class BstMinimalHeight {

	/*
	 * Given a sorted (increasing order) array write an algorithm to 
	 * create a binary search tree with minimal height
	 * 
	 * CtCI 4.2
	 */
	
	public static BinaryTreeNode createBalancedBst(int[] a, int start, int end) {
		if (end <= start) return null;
		int mid = (start + end)/2;
		BinaryTreeNode root = new BinaryTreeNode(a[mid]);
		root.left = createBalancedBst(a, start, mid);
		root.right = createBalancedBst(a, mid + 1, end);
		return root;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		BinaryTreeNode bst = createBalancedBst(a, 0, a.length);
		List<List<Integer>> levelOrder = new BinaryTreeTraversal().levelOrder(bst);
		for (List<Integer> list: levelOrder) {
			for (Integer l : list) {
				System.out.print("" + l + " ");
			}
			System.out.println();
		}
	}
}
