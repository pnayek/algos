package misc;

public class RemoveDuplicatesSortedArray {
	
    public int removeDuplicatesShift(int[] nums) {
        int j = nums.length - 1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == nums[i- 1]) {
                for (int k = i + 1; k <= j; k++) {
                    nums[k - 1] = nums[k];
                }
                j--;
            }
        }
        return j + 1;
    }
    
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 1; // index of the sorted array with no duplicates 
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[j - 1]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
