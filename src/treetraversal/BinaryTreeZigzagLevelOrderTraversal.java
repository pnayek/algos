package treetraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructures.BinaryTreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
	/*
	 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
	 * (ie, from left to right, then right to left for the next level and alternate between).
	 * For example:
	 * Given binary tree [3,9,20,null,null,15,7],
	 *     3
	 *    / \
	 *   9  20
	 *  / \
	 * 15  7
	 * return its zigzag level order traversal as:
	 * [ [3], [20,9], [15,7] ]
	 *  
	 * Leetcode #103, Medium
	 * 
	 */
	
	// O(n), O(n)
	public List<List<Integer>> zigzagLevelOrder(BinaryTreeNode root) {
        List<List<Integer>> order = new ArrayList<List<Integer>>();
        if (root == null) return order;
        Queue<BinaryTreeNode> level = new LinkedList<BinaryTreeNode>();
        boolean leftToRight = true;
        level.offer(root);
        while(!level.isEmpty()) {
            int size = level.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode node = level.poll();
                if (leftToRight) {
                    list.add(node.val);
                }
                else {
                    list.add(0, node.val);
                }
                if (node.left != null) level.offer(node.left);
                if (node.right != null) level.offer(node.right);
            }
            order.add(list);
            leftToRight = !leftToRight;
        }
        return order;
    }
}
