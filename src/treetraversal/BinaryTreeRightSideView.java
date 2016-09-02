package treetraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructures.BinaryTreeNode;

public class BinaryTreeRightSideView {
	
	/*
	 * Given a binary tree, imagine yourself standing on the right side of it,
	 * return the values of the nodes you can see ordered from top to bottom.
	 * For example:
	 * Given the following binary tree,
	 *    	 1            <---
	 *     /   \
	 *    2     3         <---
	 *     \     \
	 *     	5     4       <---
	 * You should return [1, 3, 4].
	 * 
	 * Leetcode #199, Medium
	 */
	
	// O(n), O(n)
	public List<Integer> rightSideView(BinaryTreeNode root) {
        List<Integer> view = new ArrayList<Integer>();
        if (root == null) return view;
        
        // push level by level to a queue
        // and print the rightmost in a level
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                // poll the nodes, push their children
                BinaryTreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            // poll the rightmost node of the level
            BinaryTreeNode node = queue.poll();
            view.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return view;
    }
}
