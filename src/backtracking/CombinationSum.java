package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	private int[] candidates;

	private List<List<Integer>> combSum(int n, int target) {
		//System.out.println(n + ", " + target);
		List<List<Integer>> combs = null;
		if (target < 0) {
			return combs;
		}
		if (target == 0) {
			// return empty list
			System.out.println("Empty list");
			combs = new ArrayList<List<Integer>>();
		}
		if (n > 0) {
			List<List<Integer>> list1 = combSum(n - 1, target); // do not include the last element
			if (list1 != null) {
				combs = new ArrayList<List<Integer>>();
				combs.addAll(list1);
			}
		}
		int x = candidates[n];
		if (x == target) {
			List<Integer> l = new ArrayList<Integer>();
			l.add(x);
			if (combs == null) {
				combs = new ArrayList<List<Integer>>();
			}
			combs.add(l);
			return combs;
		}
		if (x < target) {
			List<List<Integer>> list2 = combSum(n , target - x); // include x
			if (list2 != null) {
				if (combs == null) {
					combs = new ArrayList<List<Integer>>();
				}
				if (list2.isEmpty()) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(x);
					combs.add(list);
				}
				else {
					for (List<Integer> l: list2) {
						List<Integer> nl = new ArrayList<Integer>(l);
						nl.add(x);
						combs.add(nl);
					}
				}
			}
		}
		//System.out.println("Returning list with size: " + combs.size());
		return combs;
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		this.candidates = candidates;
		int n = candidates.length;
		List<List<Integer>> cs = combSum(n - 1, target);
		return cs == null ? new ArrayList<List<Integer>>() : cs;
	}
}
