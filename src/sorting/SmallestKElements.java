package sorting;

import java.util.ArrayList;
import java.util.List;

public class SmallestKElements {
	
	/* Returns the index of the pivot */
    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int j = start + 1;
        for (int i = start + 1; i < end; i++) {
            if (nums[i] < pivot) {
                // swap nums[j] and nums[i]
                int temp = nums[j];
                nums[j++] = nums[i];
                nums[i] = temp;
            }
        }
        nums[start] = nums[j - 1];
        nums[j - 1] = pivot;
        return j - 1;
    }
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        int start = 0; // inclusive
        int end = nums.length; // exclusive
        while (start < end) {
            int pivotIndex = partition(nums, start, end);
            if (pivotIndex < k - 1) {
                start = pivotIndex + 1;
            }
            else if (pivotIndex > k) {
                end = pivotIndex;
            }
            else {
                // pivotIndex is  k - 1 or k
                break;
            }
        }
        List<Integer> topK = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            topK.add(nums[i]);
        }
        return topK;
    }
}
