package recursion;

import datastructures.BinaryTreeNode;

public class BalancedBinaryTree {
	/*
	 * Given a binary tree, determine if it is height-balanced.
	 * For this problem, a height-balanced binary tree is defined
	 * as a binary tree in which the depth of the two subtrees of
	 * every node never differ by more than 1.
	 * 
	 * Leetcode #110, Easy
	 */
	private int isBalancedRecursive(BinaryTreeNode root) {
        if (root == null) return 0;
        int d1 = isBalancedRecursive(root.left);
        if (d1 < 0) return -1;
        int d2 = isBalancedRecursive(root.right);
        if (d2 < 0) return -1;
        int diff = d1 > d2 ? d1 - d2 : d2 - d1;
        if (diff > 1) return -1;
        int d = d1 > d2 ? d1 : d2;
        return d + 1;
    }
    
    public boolean isBalanced(BinaryTreeNode root) {
        return isBalancedRecursive(root) >= 0;
    }
}
