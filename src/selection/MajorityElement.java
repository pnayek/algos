package selection;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {
	/*
	 * Leetcode #169, Easy
	 */
	public int majorityElementNaive(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int val = 0;
            if (counts.containsKey(nums[i])) {
                val = counts.get(nums[i]);
            }
            counts.put(nums[i], val + 1);
        }
        for (int k : counts.keySet()) {
            if (counts.get(k) > nums.length/2) {
                return k;
            }
        }
        return -1;
    }
    
    public int majorityElementMinorOpt(int[] nums) {
    	// optimization: keep counts for keys that occurred
    	// before half the array
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > nums.length/2 && !counts.containsKey(nums[i])) {
                continue;
            }
            int val = 0;
            if (counts.containsKey(nums[i])) {
                val = counts.get(nums[i]);
            }
            counts.put(nums[i], val + 1);
        }
        for (int k : counts.keySet()) {
            if (counts.get(k) > nums.length/2) {
                return k;
            }
        }
        return -1;
    }
    
    public int majorityElementSort(int[] nums) {
    	// majority element must be the median of the array
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    
    public int majorityElementBM(int[] nums) {
    	// observation: count(majority element) > count(others)
    	// if count of any element - count of others is less than 0
    	// reset the count, change the majority element
    	// Boyer Moore Majority Vote Algorithm
        int count = 1;
        int majorityElement = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majorityElement) {
                count++;
            }
            else {
                count--;
            }
            if (count == 0) {
                // for majority element final count can never be zero
                majorityElement = nums[i];
                count = 1;
            }
        }
        return majorityElement;
    }
}
