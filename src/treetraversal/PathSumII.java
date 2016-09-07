package treetraversal;

import java.util.ArrayList;
import java.util.List;

import datastructures.BinaryTreeNode;

public class PathSumII {
	/*
	 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
	 * For example:
	 * Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
        return
        [   
          [5,4,11,2],
          [5,8,4,5]
		]
		
	 * Leetcode #113, Medium
	 */
	
	// O(n), O(n^2)
	public List<List<Integer>> pathSum(BinaryTreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        int v = root.val;
        if (root.left == null && root.right == null) {
            // leaf node
            if (v == sum) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(v);
                res.add(list);
            }
            return res;
        }
        List<List<Integer>> resLeft = pathSum(root.left, sum - v);
        for (List<Integer> l: resLeft) {
            l.add(0, v);
            res.add(l);
        }
        List<List<Integer>> resRight = pathSum(root.right, sum - v);
        for (List<Integer> l: resRight) {
            l.add(0, v);
            res.add(l);
        }
        return res;
    }
}
