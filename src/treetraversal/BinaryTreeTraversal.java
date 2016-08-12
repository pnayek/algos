package treetraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructures.BinaryTreeNode;

public class BinaryTreeTraversal {
	/*
	 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
	 * (ie, from left to right, level by level from leaf to root).
	 * 
	 * Leetcode #107, Easy
	 * CtCI 4.3
	 */
	public List<List<Integer>> levelOrderBottom(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<Integer>(n);
            for (int i = 0; i < n; i++) {
                BinaryTreeNode node = queue.poll();
                list.add(node.val);
                BinaryTreeNode left = node.left;
                BinaryTreeNode right = node.right;
                if (left != null) queue.add(left);
                if (right != null) queue.add(right);
            }
            result.add(0, list);
        }
        return result;
    }
	
	public List<List<Integer>> levelOrder(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<Integer>(n);
            for (int i = 0; i < n; i++) {
                BinaryTreeNode node = queue.poll();
                list.add(node.val);
                BinaryTreeNode left = node.left;
                BinaryTreeNode right = node.right;
                if (left != null) queue.add(left);
                if (right != null) queue.add(right);
            }
            result.add(list);
        }
        return result;
    }
	
	public List<List<Integer>> levelOrderWithNull(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<Integer>(n);
            for (int i = 0; i < n; i++) {
                BinaryTreeNode node = queue.poll();
                if (node == null) {
                	list.add(-1);
                }
                list.add(node.val);
                BinaryTreeNode left = node.left;
                BinaryTreeNode right = node.right;
                queue.add(left);
                queue.add(right);
            }
            result.add(list);
        }
        return result;
    }
}
