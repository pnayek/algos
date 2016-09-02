package recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (n < k || k == 0) return lists;
        if (n == k) {
            // one way -- choose all the elements
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 1; i <= k; i++)
                list.add(i);
            lists.add(list);
            return lists;
        }
        List<List<Integer>> lists1 = combine(n - 1, k - 1);
        // add n to all the lists
        if (lists1.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(n);
            lists1.add(list);
        }
        else {
            for (List<Integer> list : lists1) {
                list.add(n);
            }
        }
        List<List<Integer>> lists2 = combine(n - 1, k);
        lists.addAll(lists1);
        lists.addAll(lists2);
        return lists; 
    }
}
