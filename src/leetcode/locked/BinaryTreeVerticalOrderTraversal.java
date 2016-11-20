package leetcode.locked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import leetcode.contest.SumOfLeftLeaves.TreeNode;

/*
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
	
	If two nodes are in the same row and column, the order should be from left to right.
	
	Examples:
	
	Given binary tree [3,9,20,null,null,15,7],
	   3
	  /\
	 /  \
	 9  20
	    /\
	   /  \
	  15   7
	return its vertical order traversal as:
	[
	  [9],
	  [3,15],
	  [20],
	  [7]
	]
	Given binary tree [3,9,8,4,0,1,7],
	     3
	    /\
	   /  \
	   9   8
	  /\  /\
	 /  \/  \
	 4  01   7
	return its vertical order traversal as:
	[
	  [4],
	  [9],
	  [3,0,1],
	  [8],
	  [7]
	]
	Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
	     3
	    /\
	   /  \
	   9   8
	  /\  /\
	 /  \/  \
	 4  01   7
	    /\
	   /  \
	   5   2
	return its vertical order traversal as:
	[
	  [4],
	  [9,5],
	  [3,0,1],
	  [8,2],
	  [7]
	]
 *
 * Leetcode #314, Medium
 * Facebook, Google, Snapchat
 */
public class BinaryTreeVerticalOrderTraversal {

	// 6ms
	public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<Integer> queue2 = new LinkedList<Integer>();
        queue1.offer(root);
        queue2.offer(0);
        int min = 0, max = 0;
        while (!queue1.isEmpty()) {
            TreeNode n = queue1.poll();
            int x = queue2.poll();
            min = x < min ? x : min;
            max = x > max ? x : max;
            List<Integer> l;
            if (map.containsKey(x)) {
                l = map.get(x);
            }
            else {
                l = new ArrayList<Integer>();
                map.put(x, l);
            }
            l.add(n.val);
            TreeNode n1 = n.left;
            if (n1 != null) {
                queue1.offer(n1);
                queue2.offer(x - 1);
            }
            n1 = n.right;
            if (n1 != null) {
                queue1.offer(n1);
                queue2.offer(x + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
	
	
	public class Pair {
        TreeNode node;
        int x;
        public Pair(TreeNode node, int x) {
            this.node = node;
            this.x = x;
        }
    }
    
	// 11ms
    public List<List<Integer>> verticalOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            TreeNode n = p.node;
            int x = p.x;
            List<Integer> l;
            if (map.containsKey(x)) {
                l = map.get(x);
            }
            else {
                l = new ArrayList<Integer>();
                map.put(x, l);
            }
            l.add(n.val);
            TreeNode n1 = n.left;
            if (n1 != null) {
                queue.offer(new Pair(n1, x - 1));
            }
            n1 = n.right;
            if (n1 != null) {
                queue.offer(new Pair(n1, x + 1));
            }
        }
        res.addAll(map.values());
        return res;
    }
    
    TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
    
	// 8ms
	public List<List<Integer>> verticalOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<Integer> queue2 = new LinkedList<Integer>();
        queue1.offer(root);
        queue2.offer(0);
        while (!queue1.isEmpty()) {
            TreeNode n = queue1.poll();
            int x = queue2.poll();
            List<Integer> l;
            if (map.containsKey(x)) {
                l = map.get(x);
            }
            else {
                l = new ArrayList<Integer>();
                map.put(x, l);
            }
            l.add(n.val);
            TreeNode n1 = n.left;
            if (n1 != null) {
                queue1.offer(n1);
                queue2.offer(x - 1);
            }
            n1 = n.right;
            if (n1 != null) {
                queue1.offer(n1);
                queue2.offer(x + 1);
            }
        }
        res.addAll(map.values());
        return res;
    }
	
	// 10ms
    public List<List<Integer>> verticalOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
        List list = new ArrayList(2);
        list.add(root);
        list.add(0);
        queue.offer(list);
        while (!queue.isEmpty()) {
            list = queue.poll();
            TreeNode n = (TreeNode) list.get(0);
            int x = (Integer) list.get(1);
            List<Integer> l;
            if (map.containsKey(x)) {
                l = map.get(x);
            }
            else {
                l = new ArrayList<Integer>();
                map.put(x, l);
            }
            l.add(n.val);
            TreeNode n1 = n.left;
            if (n1 != null) {
                list = new ArrayList(2);
                list.add(n1);
                list.add(x - 1);
                queue.offer(list);
            }
            n1 = n.right;
            if (n1 != null) {
                list = new ArrayList(2);
                list.add(n1);
                list.add(x + 1);
                queue.offer(list);
            }
        }
        res.addAll(map.values());
        return res;
    }
}
