package leetcode.locked;

import java.util.HashMap;
import java.util.Map;

import leetcode.contest.SumOfLeftLeaves.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {

	/*
	 * Given a binary tree, find the length of the longest consecutive sequence path.

		The path refers to any sequence of nodes from some starting node to any node
		in the tree along the parent-child connections. The longest consecutive path
		need to be from parent to child (cannot be the reverse).
		
		For example,
		   1
		    \
		     3
		    / \
		   2   4
		        \
		         5
		Longest consecutive sequence path is 3-4-5, so return 3.
		   2
		    \
		     3
		    / 
		   2    
		  / 
		 1
		Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
	 *
	 * #298, M
	 * Google
	 */
	
	// 26ms
	private Map<TreeNode, Integer> cache1 = new HashMap<TreeNode, Integer>();
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (cache1.containsKey(root)) return cache1.get(root);
        int max = 1;
        int v1 = longestConsecutive(root.left);
        max = v1 > max ? v1 : max;
        int v2 = longestConsecutive(root.right);
        max = v2 > max ? v2 : max;
        int v3 = longestConsecutiveIncludingRoot(root);
        max = v3 > max ? v3 : max;
        cache1.put(root, max);
        return max;
    }
    
    private Map<TreeNode, Integer> cache2 = new HashMap<TreeNode, Integer>();
    private int longestConsecutiveIncludingRoot(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (cache2.containsKey(root)) return cache2.get(root);
        int v1 = root.left == null || root.val + 1 != root.left.val ? 1 : 1 + longestConsecutiveIncludingRoot(root.left);
        int v2 = root.right == null || root.val + 1 != root.right.val ? 1 : 1 + longestConsecutiveIncludingRoot(root.right);
        int max = v1 > v2 ? v1 : v2;
        cache2.put(root, max);
        return max;
    }
    
	// 354ms
	public int longestConsecutive1(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int max = 1;
        int v1 = longestConsecutive(root.left);
        max = v1 > max ? v1 : max;
        int v2 = longestConsecutive(root.right);
        max = v2 > max ? v2 : max;
        int v3 = longestConsecutiveIncludingRoot1(root);
        return v3 > max ? v3 : max;
    }
    
    private int longestConsecutiveIncludingRoot1(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int v1 = root.left == null || root.val + 1 != root.left.val ? 1 : 1 + longestConsecutiveIncludingRoot1(root.left);
        int v2 = root.right == null || root.val + 1 != root.right.val ? 1 : 1 + longestConsecutiveIncludingRoot1(root.right);
        return v1 > v2 ? v1 : v2;
    }
}
