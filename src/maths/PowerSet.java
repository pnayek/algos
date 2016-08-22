package maths;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSet {

	private static Set<Integer> getPowerSet(int y, int l) {
		//System.out.println("Powerset: " + y + ", " + l);
        Set<Integer> ps = new HashSet<Integer>();
        ps.add(y); ps.add(0);
        if (y == 0) return ps;
        while ((y & l) == 0) {
            l >>= 1;
            if (l == 0) break;
        }
        if (l != 0) {
            Set<Integer> s = getPowerSet(y - l, l >> 1);
            for (int i : s) {
            	//System.out.println("y: " + y + ", l: " + l + ", adding " + (i + l));
            	ps.add(i);
                ps.add(i + l);
            }
        }
        return ps;
    }
	
	private static boolean isSubset(int i, int y) {
        return (i & y) == i;
    }
	
	private static Set<Integer> getPowerSet(int y) {
		int k = y;
		Set<Integer> ps = new HashSet<Integer>();
		while (true) {
			ps.add(k);
			if (k == 0) break;
			k = (k - 1) & y;
		}
		return ps;
	}
    
	private static List<List<Integer>> getSubsets(int l) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>(l);
        long sum = 0;
        for (int y = 0; y < l; y++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i <= y; i++) {
                if (isSubset(i, y)) {
                    list.add(i);
                }
            }
            sum += list.size();
            System.out.println("y: " + y + "sum: " + sum);
            subsets.add(list);
        }
        //System.out.println(sum);
        return subsets;
    }
	
	public static void main(String[] args) {
		/*
		long t0 = System.currentTimeMillis();
		Set<Integer> ps = getPowerSet((1 << 16) - 1, 1 << 15);
		long t1 = System.currentTimeMillis();
		
		for (int i : ps)
			System.out.print("" + i + ", ");
		System.out.println();
		*/
		/*
		System.out.println("time taken to get powerset of 1 << 16 - 1: " + (t1 - t0));
		
		Set<Integer> ps1 = new HashSet<Integer>();
		long t4 = System.currentTimeMillis();
		int y = (1 << 16) - 1;
		for (int i = 0; i <= y; i++) {
            if (isSubset(i, y)) {
                ps1.add(i);
            }
        }
		long t5 = System.currentTimeMillis();
		System.out.println("time taken to get all subsets of 1 << 16 - 1: " + (t5 - t4));
		*/
		long t2 = System.currentTimeMillis();
		List<List<Integer>> subsets = getSubsets(1 << 16);
		long t3 = System.currentTimeMillis();
		
		System.out.println("time taken to get all subsets: " + (t3 - t2));
		
	}
}
