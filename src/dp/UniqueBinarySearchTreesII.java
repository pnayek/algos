package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import datastructures.BinaryTreeNode;

public class UniqueBinarySearchTreesII {
	/*
	 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
		For example,
		Given n = 3, your program should return all 5 unique BST's shown below.

		   1         3     3      2      1
		    \       /     /      / \      \
		     3     2     1      1   3      2
		    /     /       \                 \
		   2     1         2                 3
		   
	 *	Leetcode #95, Medium
	 */
	
	private static Map<String, List<BinaryTreeNode>> map = new HashMap<String, List<BinaryTreeNode>>();

	public List<BinaryTreeNode> generateTrees(int start, int end) {
		//System.out.println("start: " + start + ", end: " + end);
		List<BinaryTreeNode> res = new ArrayList<BinaryTreeNode>();
		if (end < start) return res;
		String key = start + ", " + end;
		if (map.containsKey(start + ", " + end)) {
			return map.get(key);
		}
		for (int i = start; i <= end; i++) {
			// i is the root
			// start ... i - 1 will be used to form the left subtree
			// i + 1 ... end will be used to form the right subtree
			List<BinaryTreeNode> leftTree = generateTrees(start, i - 1);
			List<BinaryTreeNode> rightTree = generateTrees(i + 1, end);
			if (leftTree.isEmpty() && rightTree.isEmpty()) {
				BinaryTreeNode root = new BinaryTreeNode(i);
				res.add(root);
			}
			else if (leftTree.isEmpty()) {
				for (BinaryTreeNode r : rightTree) {
					BinaryTreeNode root = new BinaryTreeNode(i);
					root.right = r;
					res.add(root);
				}
			}
			else if (rightTree.isEmpty()) {
				for (BinaryTreeNode l : leftTree) {
					BinaryTreeNode root = new BinaryTreeNode(i);
					root.left = l;
					res.add(root);
				}
			}
			else {
				for (BinaryTreeNode l : leftTree) {
					for (BinaryTreeNode r : rightTree) {
						BinaryTreeNode root = new BinaryTreeNode(i);
						root.left = l;
						root.right = r;
						res.add(root);
					}
				}
			}

		}
		/*
        System.out.print("res: [");
        for (BinaryTreeNode n: res) {
            System.out.print(n.val + ", ");
        }
        System.out.println("]");
		 */
		map.put(key, res);
		return res;
	}
	
	
	public List<BinaryTreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}
}
