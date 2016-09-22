package bitmanip;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	/*
	 * Given a set of distinct integers, nums, return all possible subsets.
	 * Note: The solution set must not contain duplicate subsets.
	 * For example,
	 * If nums = [1,2,3], a solution is:
		[
		  [3],
		  [1],
		  [2],
		  [1,2,3],
		  [1,3],
		  [2,3],
		  [1,2],
		  []
		]
	 * Leetcode #78, Medium
	 * Amazon, Facebook, Uber
	 */
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        int l = nums.length;
        int n = 1 << l;
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < l; j++) {
                if ((i & (1 << j)) != 0) {
                    // jth bit from right is set
                    // include nums[j] in list
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }
}
