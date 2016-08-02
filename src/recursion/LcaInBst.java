package recursion;

import datastructures.BinaryTreeNode;

public class LcaInBst {
	
	/*
	 * Leetcode #235 Easy, HackerRank->Data Structures->Trees Easy
	 */
	public BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        if (p.val < root.val && q.val < root.val) {
            // both p and q are in the left subtree
            return lowestCommonAncestor(root.left, p, q);
        }
        else if (p.val >= root.val && q.val >= root.val) {
            // both p and q are in the right subtree
            return lowestCommonAncestor(root.right, p, q);
        }
        else {
            // p and q are in different subtrees
            return root;
        }
    }
}
