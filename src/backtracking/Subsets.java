package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }
    
    private List<List<Integer>> subsets(int[] nums, int start) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0 || start == nums.length) {
            return res;
        }
        int n = nums[start];
        List<List<Integer>> res1 = subsets(nums, start + 1);
        if (res1.size() == 0) {
            List<Integer> l1 = new ArrayList<Integer>();
            l1.add(n);
            res.add(l1);
            List<Integer> l2 = new ArrayList<Integer>();
            res.add(l2);
        }
        else {
            for (List<Integer> list: res1) {
                List<Integer> l1 = new ArrayList<Integer>();
                l1.addAll(list);
                res.add(l1);
                List<Integer> l2 = new ArrayList<Integer>();
                l2.add(n);
                l2.addAll(list);
                res.add(l2);
            }
        }
        return res;
    }
}
