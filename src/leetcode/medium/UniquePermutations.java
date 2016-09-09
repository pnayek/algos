package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniquePermutations {
	/*
	 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
	 * For example, [1,1,2] have the following unique permutations:
	 * [ [1,1,2], [1,2,1], [2,1,1] ]
	 * 
	 * Leetcode #47, Medium
	 */
	
	private boolean permuteUniqueNext(int[] nums) {
        int n = nums.length;
        int j = n - 1;
        while (j > 0) {
            // first correct order from the right
            if (nums[j - 1] < nums[j]) break;
            j--;
        }
        if (j == 0) return true; // non increasing order
        // find the rightmost number that is greater than nums[j - 1]
        for (int i = n - 1; i > j - 1; i--) {
            if (nums[i] > nums[j - 1]) {
                // swap them
                int temp = nums[i];
                nums[i] = nums[j - 1];
                nums[j - 1] = temp;
                // reverse nums[j ... n - 1]
                rev(nums, j, n - 1);
                return false;
            }
        }
        return true;
    }
    
    private void rev(int[] nums, int start, int end) {
        int i = start; int j = end;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }
    
    private List<Integer> getList(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int n: nums) {
            list.add(n);
        }
        return list;
    }
    
    // O(n.n!), O(n.n!)
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        boolean done = false;
        while (!done) {
            res.add(getList(copy));
            done = permuteUniqueNext(copy);
        }
        return res;
    }
}
