package treetraversal;

import java.util.HashMap;
import java.util.Map;

import datastructures.BinaryTreeNode;

public class BuildTreeFromPreAndInOrders {
	/*
	 * Given preorder and inorder traversal of a tree, construct the binary tree.
	 * Note: You may assume that duplicates do not exist in the tree.
	 * 
	 * Leetcode #105, Medium
	 */
	
	private int[] preOrder;
    private int[] inOrder;
    private Map<Integer, Integer> idMap = new HashMap<Integer, Integer>();
    
    private BinaryTreeNode buildTree(int preStart, int preEnd, int inStart, int inEnd) {
        if (preEnd < preStart || inEnd < inStart) return null;
        int v = preOrder[preStart];
        int vPos = idMap.get(v);
        BinaryTreeNode root = new BinaryTreeNode(v);
        int leftSize = vPos - inStart;
        root.left = buildTree(preStart + 1, preStart + leftSize, inStart, vPos - 1);
        root.right = buildTree(preStart + leftSize + 1, preEnd, vPos + 1, inEnd);
        return root;
    }
    
    // O(n), O(n)
    public BinaryTreeNode buildTree(int[] preorder, int[] inorder) {
        preOrder = preorder;
        inOrder = inorder;
        for (int i = 0; i < inOrder.length; i++)
            idMap.put(inOrder[i], i);
        return buildTree(0, preOrder.length - 1, 0, inOrder.length - 1);
    }
}
