package leetcode.locked;

import leetcode.contest.SumOfLeftLeaves.TreeNode;

public class ClosestBstValue {

	/*
	 * Given a non-empty binary search tree and a target value,
	 * find the value in the BST that is closest to the target.
	 * Note:
	 * Given target value is a floating point.
	 * You are guaranteed to have only one unique value in the BST that is closest to the target.
	 * 
	 * #270, E
	 * Microsoft, Google, Snapchat
	 */
	
	public int closestValue(TreeNode root, double target) {
        double min = Double.MAX_VALUE;
        int minVal = root.val; 
        TreeNode p = root;
        while (p != null) {
            if (p.val == target) return p.val;
            else if (target < p.val) {
                double d = p.val - target;
                if (d < min) {
                    min = d;
                    minVal = p.val;
                }
                p = p.left;
            }
            else {
                double d = target - p.val;
                if (d < min) {
                    min = d;
                    minVal = p.val;
                }
                p = p.right;
            }
        }
        return minVal;
    }
}
