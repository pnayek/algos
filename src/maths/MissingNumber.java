package maths;

public class MissingNumber {
	/*
	 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
	 * find the one that is missing from the array.
	 * For example,
	 * Given nums = [0, 1, 3] return 2.
	 * Note: Your algorithm should run in linear runtime complexity.
	 * Could you implement it using only constant extra space complexity?
	 * 
	 * Leetcode #268, Medium
	 */
	
	// O(n), O(1)
	public int missingNumber(int[] nums) {
        int n = nums.length;
        long sum1 = (long) n * (n + 1) / 2;
        long sum2 = 0;
        for (int i: nums) sum2 += i;
        return (int) (sum1 - sum2);
    }
}
