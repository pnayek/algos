package leetcode.locked;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

	/*
	 * Given a sorted integer array where the range of elements
	 * are in the inclusive range [lower, upper], return its missing ranges.
	 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99,
	 * return ["2", "4->49", "51->74", "76->99"].
	 * 
	 * #163, M
	 * Google
	 */
	
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i <= nums.length; i++) {
            if (i > 0 && nums[i - 1] == Integer.MAX_VALUE) continue;
            int u = i == 0 ? lower : nums[i - 1] + 1;
            if (i < nums.length && nums[i] == Integer.MIN_VALUE) continue;
            int v = i == nums.length ? upper : nums[i] - 1;
            if (u == v) {
                res.add("" + u);
            }
            else if (u < v) {
                res.add(u + "->" + v);
            }
        }
        return res;
    }
}
