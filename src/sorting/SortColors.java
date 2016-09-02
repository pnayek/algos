package sorting;

public class SortColors {
	
	/*
	 * Given an array with n objects colored red, white or blue,
	 * sort them so that objects of the same color are adjacent,
	 * with the colors in the order red, white and blue.
	 * 
	 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
	 * Note:
	 * You are not supposed to use the library's sort function for this problem.
	 * 
	 * Follow up:
	 * Could you come up with an one-pass algorithm using only constant space?
	 * 
	 * Leetcode #75, Medium
	 * 
	 */
	
	// O(n), O(1), 1 pass
	public void sortColors(int[] nums) {
        int n = nums.length;
        // first non 0 position
        int j = 0;
        while (j < n && nums[j] == 0) {
            j++;
        }
        if (j == n) return;
        
        // first non 2 position from back
        int k = n - 1;
        while (k >= 0 && nums[k] == 2) {
            k--;
        }
        if (k < 0) return;
        
        int i = j;
        while (i <= k) {
            if (nums[i] == 0) {
                if (i == j) {
                    i++; j++;
                    continue;
                }
                // swap nums[i] and nums[j]
                int temp = nums[j];
                nums[j++] = nums[i];
                nums[i] = temp;
                if (temp == 1) i++;
            }
            else if (nums[i] == 2) {
                // swap nums[i] and nums[k]
                int temp = nums[k];
                nums[k--] = nums[i];
                nums[i] = temp;
                if (temp == 1) i++;
            }
            else {
                i++;
            }
        }
    }
	
	// O(n), O(1)
	public void sortColorsTwoPass(int[] nums) {
        int n = nums.length;
        int red = 0;
        int white = 0;
        for (int i: nums) {
            if (i == 0) red++;
            else if (i == 1) white++;
        }
        for (int i = 0; i < n; i++) {
            if (i < red) nums[i] = 0;
            else if (i < red + white) nums[i] = 1;
            else nums[i] = 2;
        }
    }
}
