package leetcode.medium;

public class ContainerWithMostWater {
	/*
	 * Given n non-negative integers a1, a2, ..., an,
	 * where each represents a point at coordinate (i, ai).
	 * n vertical lines are drawn such that the two end points of line i
	 * are at (i, ai) and (i, 0).
	 * Find two lines, which together with x-axis forms a container,
	 * such that the container contains the most water.
	 * Note: You may not slant the container.
	 * 
	 * Leetcode #11, Medium
	 */
	
	// O(n), O(1)
	public int maxArea(int[] height) {
        int max = 0, lo = 0, hi = height.length - 1;
        while (lo < hi) {
            int area = 0;
            if (height[lo] < height[hi]) {
                area = height[lo] * (hi - lo);
                lo++;
            }
            else {
                area = height[hi] * (hi - lo);
                hi--;
            }
            max = area > max ? area : max;
        }
        return max;
    }
}
