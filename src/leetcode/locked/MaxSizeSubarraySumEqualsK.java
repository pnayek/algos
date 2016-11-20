package leetcode.locked;

import java.util.HashMap;
import java.util.Map;

public class MaxSizeSubarraySumEqualsK {

	/*
	 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
	 * If there isn't one, return 0 instead.
	 * Note: The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
	 * Example 1:
	 * Given nums = [1, -1, 5, -2, 3], k = 3, return 4.
	 * (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
	 * 
	 * Example 2:
	 * Given nums = [-2, -1, 2, 1], k = 1, return 2.
	 * (because the subarray [-1, 2] sums to 1 and is the longest)
	 * 
	 * Follow Up: Can you do it in O(n) time?
	 * 
	 * Leetcode #325, Medium
	 * Facebook, Palantir
	 */
	
	// 34ms
	public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        Map<Integer, Integer> locs = new HashMap<Integer, Integer>();
        int sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum == k) {
                max = i + 1 > max ? i + 1 : max;
            }
            else if (locs.containsKey(sum - k)) {
                int j = locs.get(sum - k);
                max = i - j > max ? i - j : max;
            }
            if (!locs.containsKey(sum))
                locs.put(sum, i);
        }
        return max;
    }
	
	// 653ms
	public int maxSubArrayLenNaive(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] runningSum = new int[n];
        for (int i = 0; i < n; i++) {
            runningSum[i] = i == 0 ? nums[i] : runningSum[i - 1] + nums[i];
        }
        for (int l = n; l >= 1; l--) {
            for (int i = 0; i + l - 1 < n; i++) {
                int sum = i == 0 ? runningSum[i + l - 1] : runningSum[i + l - 1] - runningSum[i - 1];
                if (sum == k) return l;
            }        
        }
        return 0;
    }
}
