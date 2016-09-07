package treetraversal;

import java.util.HashMap;
import java.util.Map;

import datastructures.BinaryTreeNode;

public class BuildTreeFromInAndPostOrders {
	/*
	 * Given inorder and postorder traversal of a tree, construct the binary tree.
	 * Note: You may assume that duplicates do not exist in the tree.
	 * 
	 * Leetcode #106, Medium
	 */
	
	private int[] inOrder;
    private int[] postOrder;
    private Map<Integer, Integer> idMap = new HashMap<Integer, Integer>();
    
    private BinaryTreeNode buildTree(int inStart, int inEnd, int postStart, int postEnd) {
        //System.out.println(inStart + ", " + inEnd + ", " + postStart + ", " + postEnd);
        if (inEnd < inStart || postEnd < postStart) return null;
        int v = postOrder[postEnd];
        int vPos = idMap.get(v);
        BinaryTreeNode root = new BinaryTreeNode(v);
        int leftsize = vPos - inStart;
        root.left = buildTree(inStart, vPos - 1, postStart, postStart + leftsize - 1);
        root.right = buildTree(vPos + 1, inEnd, postStart + leftsize, postEnd - 1);
        return root;
    }
    
    public BinaryTreeNode buildTree(int[] inorder, int[] postorder) {
        inOrder = inorder;
        postOrder = postorder;
        for (int i = 0; i < inOrder.length; i++)
            idMap.put(inOrder[i], i);
        return buildTree(0, inOrder.length - 1, 0, postOrder.length - 1);
    }
    
    private int find(int[] a, int start, int end, int v) {
        for (int i = start; i <= end; i++) {
            if (a[i] == v) return i;
        }
        return -1;
    }
    
    private BinaryTreeNode buildTreeLinearFind(int inStart, int inEnd, int postStart, int postEnd) {
        //System.out.println(inStart + ", " + inEnd + ", " + postStart + ", " + postEnd);
        if (inEnd < inStart || postEnd < postStart) return null;
        int v = postOrder[postEnd];
        int vPos = find(inOrder, inStart, inEnd, v);
        BinaryTreeNode root = new BinaryTreeNode(v);
        int leftsize = vPos - inStart;
        root.left = buildTreeLinearFind(inStart, vPos - 1, postStart, postStart + leftsize - 1);
        root.right = buildTreeLinearFind(vPos + 1, inEnd, postStart + leftsize, postEnd - 1);
        return root;
    }
    
    public BinaryTreeNode buildTreeLinearFind(int[] inorder, int[] postorder) {
        this.inOrder = inorder;
        this.postOrder = postorder;
        return buildTreeLinearFind(0, inOrder.length - 1, 0, postOrder.length - 1);
    }
    
}
