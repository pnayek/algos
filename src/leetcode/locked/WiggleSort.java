package leetcode.locked;

import java.util.Arrays;

public class WiggleSort {

	/*
	 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
	 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
	 * 
	 * #280, M
	 * Google
	 */
	
	// 1ms
	public void wiggleSort(int[] nums) {
        // swap if needed
        boolean less = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if ((less && nums[i] > nums[i + 1]) || (!less && nums[i] < nums[i + 1])) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;    
            }
            less = !less;
        }
    }
	
	// 7ms
	public void wiggleSort1(int[] nums) {
        // sort and then do pairwise swapping
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
    }
}
