package leetcode.locked;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {

	/*
	 * Numbers can be regarded as product of its factors. For example,

		8 = 2 x 2 x 2;
		  = 2 x 4.
		Write a function that takes an integer n and return all possible combinations of its factors.
		
		Note: 
		You may assume that n is always positive.
		Factors should be greater than 1 and less than n.
		Examples: 
		input: 1
		output: 
		[]
		input: 37
		output: 
		[]
		input: 12
		output:
		[
		  [2, 6],
		  [2, 2, 3],
		  [3, 4]
		]
		input: 32
		output:
		[
		  [2, 16],
		  [2, 2, 8],
		  [2, 2, 2, 4],
		  [2, 2, 2, 2, 2],
		  [2, 4, 4],
		  [4, 8]
		]
	 *
	 * #254, M
	 * LinkedIn, Uber
	 */
	
	// 2ms
	public List<List<Integer>> getFactors(int n) {
        return getFactors(n, 2);
    }
    
    private List<List<Integer>> getFactors(int n, int x) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n < 4) return res;
        for (int i = x; i * i <= n; i++) {
            if (n % i == 0) {
                // i divides n
                List<Integer> list = new ArrayList<Integer>(2);
                list.add(i); list.add(n/i);
                res.add(list);
                List<List<Integer>> res1 = getFactors(n/i, i);
                for (List<Integer> l : res1) {
                    List<Integer> l1 = new ArrayList<Integer>();
                    l1.add(i); l1.addAll(l);
                    res.add(l1);
                }
            }
        }
        return res;
    }
}
