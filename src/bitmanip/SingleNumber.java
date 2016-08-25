package bitmanip;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
	/*
	 * Given an array of numbers nums, in which exactly two elements appear only once
	 * and all the other elements appear exactly twice. Find the two elements that appear only once.
	 * For example:
	 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
	 * Note:
	 * The order of the result is not important. So in the above example, [5, 3] is also correct.
	 * Your algorithm should run in linear runtime complexity.
	 * Could you implement it using only constant space complexity?
	 */
	
	// O(n), O(n)
	public int[] singleNumberHashSet(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i: nums) {
            if (set.contains(i)) {
                set.remove(i);
            }
            else {
                set.add(i);
            }
        }
        int[] res = new int[2];
        int count = 0;
        for (int i: set) {
            res[count++] = i;
        }
        return res;
    }
    
	// O(n), O(1)
    public int[] singleNumber(int[] nums) {
        // Pass 1: compute XOR
        int s = 0;
        for (int n : nums) {
            s ^= n;
        }
        
        // s has at least one 1 bit set
        // find the rightmost set bit in s
        int mask = s & -s; // this has all other bits unset
        
        // the numbers in nums can be conceptually divided into two groups
        // group 1: has the same bit set as mask
        // group 2: has that bit unset
        // x and y must belong to different groups
        // Pass 2: compute XOR of all elements in group 1 -- x
        // compute XOR of all elements in group 2 -- y
        int[] res = {0, 0};
        for (int n : nums) {
            if ((n & mask) != 0) {
                // the bit is set
                res[0] ^= n;
            }
            else {
                // the bit is not set
                res[1] ^= n;
            }
        }
        return res;
    }
}
