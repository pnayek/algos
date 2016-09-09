package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
List<Integer> candidates = new ArrayList<Integer>();
    
    private List<List<Integer>> combSum(int start, int target) {
        //System.out.println("start: " + start + ", target: " + target);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (start >= candidates.size()) {
            //System.out.println("Returning empty list");
            return res;
        }
        int c = candidates.get(start);
        int count = 1;
        while (start + count < candidates.size() && candidates.get(start + count) == c) {
            count++;
        }
        List<List<Integer>> res1 = combSum(start + count, target); // do not include c
        res.addAll(res1);
        int i = 1;
        while (target >= i * c && i <= count) {
            if (target == i * c) {
                List<Integer> l = new ArrayList<Integer>();
                for (int j = 0; j < i; j++)
                    l.add(0, c);
                res.add(l);
            }
            else {
                List<List<Integer>> res2 = combSum(start + count, target - i * c); // include c i times
                for (List<Integer> l: res2) {
                    for (int j = 0; j < i; j++)
                        l.add(0, c);
                    res.add(l);
                }
            }
            i++;
        }
        return res;
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int c: candidates) {
            if (c <= target) {
                this.candidates.add(c);
            }
        }
        return combSum(0, target);
    }
}
