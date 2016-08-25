package leetcode.medium;

public class NextPermutation {
	/*
	 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
	 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
	 * The replacement must be in-place, do not allocate extra memory.
	 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
	 * 1,2,3 -> 1,3,2
	 * 3,2,1 -> 1,2,3
	 * 1,1,5 -> 1,5,1
	 * 
	 * Leetcode #31, Medium
	 */
	
	private void reverse(int[] nums, int start, int end) {
        // start is inclusive
        // end is exclusive
        for (int i = 0; i < (end - start)/2; i++) {
            int temp = nums[start + i];
            nums[start + i] = nums[end - i - 1];
            nums[end - i - 1] = temp;
        }
    }
    
	// O(n), O(1)
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int j = n - 1;
        // keep going till you find two consecutive elements in correct order
        while (j > 0 && nums[j] <= nums[j - 1]) {
            j--;
        }
        if (j == 0) {
            // the array is in decreasing order
            // next permutation is the sorted order
            reverse(nums, 0, n);
            return;
        }
        // swap nums[j - 1] with the largest k such that nums[k] > nums[j - 1]
        int temp = nums[j - 1];
        int k = n - 1;
        while (k > j - 1 && nums[k] <= temp) {
            k--;
        }
        nums[j - 1] = nums[k];
        nums[k] = temp;
        // nums[j ... n - 1] is in decreasing order, reverse it
        reverse(nums, j, n);
    }
}
