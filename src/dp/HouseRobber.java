package dp;

public class HouseRobber {
	/*
	 * You are a professional robber planning to rob houses along a street.
	 * Each house has a certain amount of money stashed,
	 * the only constraint stopping you from robbing each of them is that
	 * adjacent houses have security system connected and
	 * it will automatically contact the police
	 * if two adjacent houses were broken into on the same night.
	 * Given a list of non-negative integers representing the amount of 
	 * money of each house, determine the maximum amount of money you can 
	 * rob tonight without alerting the police.
	 * Leetcode #198, Easy
	 */
	
	//recursion with redundant parameter
	public int robRecursive1(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        else if (end < start) return 0;
        int r1 = nums[start] + robRecursive1(nums, start + 2, end);
        int r2 = robRecursive1(nums, start + 1, end);
        return r1 > r2 ? r1 : r2;
    }
    
	// recursion with overlapping subproblems
    public int robRecursive2(int[] nums, int start) {
        if (start == nums.length - 1) return nums[start];
        else if (start > nums.length - 1) return 0;
        int r1 = nums[start] + robRecursive2(nums, start + 2);
        int r2 = robRecursive2(nums, start + 1);
        return r1 > r2 ? r1 : r2;
    }
    
    private static int[] cache;
    
    // recursion with memoization
    public int robRecursive3(int[] nums, int start) {
        if (start > nums.length - 1) return 0;
        if (cache[start] >= 0) return cache[start];
        if (start == nums.length - 1) {
            cache[start] = nums[start];
            return nums[start];
        }
        int r1 = nums[start] + robRecursive3(nums, start + 2);
        int r2 = robRecursive3(nums, start + 1);
        cache[start] = r1 > r2 ? r1 : r2;
        return cache[start];
    }
    
    public int rob(int[] nums) {
        //return robRecursive1(nums, 0, nums.length - 1);
        /*
        cache = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            cache[i] = -1; 
        return robRecursive3(nums, 0);
        */
        
        // iterative solution
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        cache = new int[nums.length];
        cache[nums.length - 1] = nums[nums.length - 1];
        cache[nums.length - 2] = nums[nums.length - 2] > cache[nums.length - 1] ? nums[nums.length - 2] : cache[nums.length - 1];
        for (int i = nums.length - 3; i >= 0; i--) {
            int r1 = nums[i] + cache[i + 2];
            int r2 = cache[i + 1];
            cache[i] = r1 > r2 ? r1 : r2;
        }
        return cache[0];
    }
}
