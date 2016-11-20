package leetcode.locked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumIII {

	/*
	 * Design and implement a TwoSum class. It should support the following operations: add and find.
	 * add - Add the number to an internal data structure.
	 * find - Find if there exists any pair of numbers which sum is equal to the value.
	 * For example, add(1); add(3); add(5);
	 * find(4) -> true
	 * find(7) -> false
	 * 
	 * #170, E
	 * LinkedIn
	 */
	
	Map<Integer, Integer> counts;
    List<Integer> distinct;
    
    public TwoSumIII() {
        counts = new HashMap<Integer, Integer>();
        distinct = new ArrayList<Integer>();
    }
    
    // Add the number to an internal data structure.
	public void add(int number) {
	    if (counts.containsKey(number)) {
	        counts.put(number, counts.get(number) + 1);
	    }
	    else {
	        counts.put(number, 1);
	        distinct.add(number);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int n : distinct) {
	        int n1 = value - n;
	        if (counts.containsKey(n1)) {
	            if (n != n1 || counts.get(n) > 1) return true;
	        }
	    }
	    return false;
	}
}
