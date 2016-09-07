package searching;

public class SearchForARange {
	/*
	 * Given a sorted array of integers, find the starting and ending position of a given target value.
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 * If the target is not found in the array, return [-1, -1].
	 * For example, 
	 * Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
	 * 
	 * Leetcode #34, Medium
	 */
	private int binarySearch(int[] nums, int start, int end, int target) {
        int lo = start;
        int hi = end;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (target == nums[mid]) return mid;
            if (nums[mid] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return -1;
    }
    
	
    public int[] searchRange(int[] nums, int target) {
        int pos = binarySearch(nums, 0, nums.length - 1, target);
        int startPos = pos;
        int endPos = pos;
        int minPos = startPos;
        int maxPos = endPos;
        while (startPos != -1) {
            startPos = binarySearch(nums, 0, startPos - 1, target);
            minPos = startPos == -1 ? minPos : startPos;
        }
        while (endPos != -1) {
            endPos = binarySearch(nums, endPos + 1, nums.length - 1, target);
            maxPos = endPos == -1 ? maxPos : endPos;
        }
        int[] res = {minPos, maxPos};
        return res;
    }
}
