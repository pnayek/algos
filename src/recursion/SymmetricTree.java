package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructures.BinaryTreeNode;

public class SymmetricTree {

	/*
	 * Leetcode #101, Easy
	 */
	private static boolean isPalindrome(List<Integer> list) {
        if (list == null || list.isEmpty() || list.size() == 1) return true;
        Integer start = list.get(0);
        Integer end = list.get(list.size() - 1);
        if (start == null && end != null) return false;
        if (start != null && end == null) return false;
        if (start == null && end == null) return isPalindrome(list.subList(1, list.size() - 1));
        return start.equals(end) && isPalindrome(list.subList(1, list.size() - 1));
    }
    
    public static boolean isSymmetric(BinaryTreeNode root) {
        // do a level order traversal
        // every level should be a palindrome
        // include nulls in the level
        if (root == null) return true;
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<Integer>(n);
            for (int i = 0; i < n; i++) {
            	BinaryTreeNode node = queue.poll();
                if (node == null) {
                    level.add(null);
                }
                else {
                    level.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (!isPalindrome(level)) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isMirror(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return root1.val == root2.val
                && isMirror(root1.left, root2.right)
                && isMirror(root1.right, root2.left);
    }
    
    public static boolean isSymmetricRecursive(BinaryTreeNode root) {
        // left and right subtrees must be mirror images
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }
    
    public boolean isSymmetricIterative(BinaryTreeNode root) {
        // left and right subtrees must be mirror images
        // push them adjacent to each other in a queue
        if (root == null) return true;
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            BinaryTreeNode t1 = queue.poll();
            BinaryTreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }
}
