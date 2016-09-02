package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	
	/*
	 * Given a collection of distinct numbers, return all possible permutations.
	 * For example,
	 * [1,2,3] have the following permutations:
	 * [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
	 * 
	 * Leetcode #46, Medium
	 */
	
	// O(n.n!), O(n.n!)
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        int[] numsCopy = nums.clone();
        Arrays.sort(numsCopy); // smallest permutation
        boolean done = false;
        while (!done) {
            List<Integer> perm = new ArrayList<Integer>();
            for (int i: numsCopy) {
                perm.add(i);
            }
            permutations.add(perm);
            done = getNextPermutation(numsCopy);
        }
        return permutations;
    }
    
    private boolean getNextPermutation(int[] nums) {
        boolean done = true;
        // find the first position from the right with correct order
        int i = nums.length - 1;
        while (i > 0) {
            if (nums[i - 1] < nums[i]) {
                // found
                done = false;
                break;
            }
            i--;
        }
        if (done) return done;
        
        // swap nums[i - 1] with the rightmost number that is greater than it
        for (int j = nums.length - 1; j >= i; j--) {
            if (nums[j] > nums[i - 1]) {
                // swap
                int temp = nums[i - 1];
                nums[i - 1] = nums[j];
                nums[j] = temp;
                break;
            }
        }
        
        // reverse everything after nums[i - 1]
        for (int k = 0; k < (nums.length - i) / 2; k++) {
            // swap
            int temp = nums[i + k];
            nums[i + k] = nums[nums.length - 1 - k];
            nums[nums.length - 1 - k] = temp;
        }
        return done;
    }
}
