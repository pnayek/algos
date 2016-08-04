package misc;

public class RemoveElement {
	/*
	 * Given an array and a value, remove all instances of
	 * that value in place and return the new length.
	 * Do not allocate extra space for another array,
	 * you must do this in place with constant memory.
	 * The order of elements can be changed.
	 * It doesn't matter what you leave beyond the new length.
	 * 
	 * Example:
	 * Given input array nums = [3,2,2,3], val = 3
	 * Your function should return length = 2,
	 * with the first two elements of nums being 2.
	 * 
	 * Hint:
	 * 1. Try two pointers.
	 * 2. Did you use the property of "the order of elements can be changed"?
	 * 3. What happens when the elements to remove are rare?
	 * 
	 * Leetcode #27, Easy
	 */
	public int removeElement1(int[] nums, int val) {
        // this is like the partition method in quicksort
        // pivot value is val
        // we want to have all elements that are not val
        // to be pushed to the left
        // this is good if elements to be removed are frequent
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                // swap ith element with jth element
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
        }
        return i;
    }
    
    public int removeElement2(int[] nums, int val) {
        // this is like the partition method in quicksort
        // pivot value is val
        // we want to have all elements that are val
        // to be pushed to the right
        // this is good if elements to be removed are rare
        int i = nums.length - 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] == val) {
                // swap ith element with jth element
                int temp = nums[i];
                nums[i--] = nums[j];
                nums[j] = temp;
            }
        }
        return i + 1;
    }
    
    public int removeElement3(int[] nums, int val) {
        // this is like removeElement1 but no swapping
        // because what we lose must be val
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
