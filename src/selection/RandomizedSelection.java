package selection;

import java.util.Random;

public class RandomizedSelection {

	public int randomizedPartition(int[] nums, int start, int end) {
        // ideally should be a random pivot
        Random rand = new Random();
        int r = start + rand.nextInt(end - start + 1);
        int pivot = nums[r];
        nums[r] = nums[start];
        nums[start] = pivot;
        int i = start + 1;
        for (int j = start + 1; j <= end; j++) {
            if (nums[j] < pivot) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
        }
        nums[start] = nums[i - 1];
        nums[i - 1] = pivot;
        return i - 1;
    }
    
    public int randomizedMedian(int[] nums, int start, int end) {
        if (end < start) return -1;
        if (start == end) return nums[start];
        int pivot = randomizedPartition(nums, start, end);
        int mid = (start + end)/2;
        if (pivot == mid) {
            return nums[pivot];
        }
        else if (pivot < mid) {
            return randomizedMedian(nums, pivot + 1, end);
        }
        else return randomizedMedian(nums, start, pivot - 1);
    }
    
}
