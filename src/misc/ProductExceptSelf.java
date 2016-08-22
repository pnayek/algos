package misc;

public class ProductExceptSelf {

	/*
	 * Leetcode #238, Medium
	 * Solve it without using division and in O(n) time
	 * Follow up: Solve it using O(1) space (not counting the output array)
	 */
	public int[] productExceptSelf(int[] nums) {
        
        // get left products
        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i  < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        
        // get right products
        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i  >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        
        // construct output
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] = left[i] * right[i];
        }
        return output;
    }

}
