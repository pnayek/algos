package dp;

public class CombinationSumIV {
	/*
	 * Given an integer array with all positive numbers and no duplicates, 
	 * find the number of possible combinations that add up to a positive integer target.
	 * Example:
	 * nums = [1, 2, 3]
	 * target = 4
	 * The possible combination ways are:
	 * (1, 1, 1, 1)
	 * (1, 1, 2)
	 * (1, 2, 1)
	 * (1, 3)
	 * (2, 1, 1)
	 * (2, 2)
	 * (3, 1)
	 * 
	 * Note that different sequences are counted as different combinations.
	 * Therefore the output is 7.
	 * 
	 */
	private int[] cache;
    private int combinationSum(int[] nums, int target) {
        if (nums.length == 0 || target <= 0) return 0;
        if (cache[target] >= 0) return cache[target];
        cache[target] = 0;
        for (int i: nums) {
            if (target == i)
                cache[target] += 1;
            else if (target > i)
                cache[target] += combinationSum(nums, target - i);
        }
        return cache[target];
    }
    
    public int combinationSum4(int[] nums, int target) {
        cache = new int[target + 1];
        cache[0] = 0;
        for (int i = 0; i <= target; i++)
            cache[i] = -1;
        return combinationSum(nums, target);
    }
}
