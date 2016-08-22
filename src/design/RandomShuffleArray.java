package design;

import java.util.Random;

public class RandomShuffleArray {

	private int[] nums;
	
    public RandomShuffleArray(int[] nums) {
        this.nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            this.nums[i] = nums[i];
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            res[i] = nums[i];
        Random rand = new Random();
        for (int i = 0; i < res.length; i++) {
            // generate a random number between i (inclusive) and n (exclusive)
            int r = i + rand.nextInt(res.length - i);
            // swap res[i] and res[r]
            int temp = res[i];
            res[i] = res[r];
            res[r] = temp;
        }
        return res;
    }
    
}
