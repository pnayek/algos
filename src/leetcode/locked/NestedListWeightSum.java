package leetcode.locked;

import java.util.List;

public class NestedListWeightSum {

	/*
	 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
	 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
	 * Example 1: Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
	 * Example 2: Given the list [1,[4,[6]]], return 27.
	 * (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
	 * 
	 * #339, E
	 * LinkedIn
	 */

	// This is the interface that allows for creating nested lists.
	// You should not implement it, or speculate about its implementation
	public interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather than a nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

	// 1ms
	public int depthSum(List<NestedInteger> nestedList) {
		return depthSum(nestedList, 1);
	}

	private int depthSum(List<NestedInteger> nestedList, int depth) {
		if (nestedList == null || nestedList.isEmpty()) return 0;
		int sum = 0;
		for (NestedInteger ni: nestedList) {
			if (ni.isInteger()) {
				sum += depth * ni.getInteger();
			}
			else {
				sum += depthSum(ni.getList(), depth + 1);
			}
		}
		return sum;
	}
}