package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
	private List<List<Integer>> combinationSum(int k, int n, int d) {
        List<List<Integer>> curr = new ArrayList<List<Integer>>();
        if (n == 0 || k == 0 || d > 9 || n < d) return curr;
        if (k == 1 && n > 9) return curr;
        if (k == 1) {
            List<Integer> l = new ArrayList<Integer>();
            l.add(n);
            curr.add(l);
            return curr;
        }
        for (int i = d; i <= 9; i++) {
            List<List<Integer>> prev = combinationSum(k - 1, n - i, i + 1);
            for (List<Integer> prevList : prev) {
                List<Integer> currList = new ArrayList<Integer>(prevList);
                currList.add(i);
                curr.add(currList);
            }
        }
        return curr;
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        return combinationSum(k, n , 1);
    }
}
