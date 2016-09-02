package searching;

public class FindMinimumInRotatedSortedArray {
	/*
	 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * Find the minimum element. You may assume no duplicate exists in the array.
	 * 
	 * Leetcode #153, Medium
	 */
	
	// O(lg n), O(1)
	public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[hi] < nums[lo]) {
                // rotated
                if (nums[mid] < nums[hi]) {
                    // search 1st half
                    hi = mid;
                }
                else {
                    // search 2nd half
                    lo = mid + 1;
                }
            }
            else {
                return nums[lo];
            }
        }
        return nums[lo];
    }
}
