package leetcode.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LexicographicalNumbers {
	/*
	 * Given an integer n, return 1 - n in lexicographical order.
	 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
	 * Please optimize your algorithm to use less time and space.
	 * The input size may be as large as 5,000,000.
	 * 
	 * Leetcode warm up contest #386, Medium 
	 */
	
	// O(n lg n), O(n)
	public static List<Integer> lexicalOrder1(int n) {
		List<Integer> list = new ArrayList<Integer>();
		if (n < 1) return list;
		String[] str = new String[n];
		for (int i = 1; i <= n; i++)
			str[i - 1] = "" + i;
		Arrays.sort(str);
		for (String s : str)
			list.add(Integer.parseInt(s));
		return list;
	}

	public static void printList(List<Integer> list) {
		for (int l : list) {
			System.out.print("" + l + ", ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		long t0 = System.currentTimeMillis();
		List<Integer> list = lexicalOrder(5000000);
		System.out.println(System.currentTimeMillis() - t0);
		//printList(list);
	}

	// O(n lg n), O(n)
	public static List<Integer> lexicalOrder2(int n) {
		List<Integer> list = new ArrayList<Integer>();
		if (n < 1) return list;
		for (int i = 1; i <= n; i++)
			list.add(i);
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer x, Integer y) {
				return x.toString().compareTo(y.toString()); 
			}
		});
		return list;
	}

	// O(n), O(n)
	public static List<Integer> lexicalOrder(int n) {
		List<Integer> list = new ArrayList<Integer>(n);
		lexicalOrderRec(1, n, list);
		return list;
	}
	
	private static void lexicalOrderRec(int k, int n, List<Integer> list) {
		if (k > n) return;  
		while (k <= n) {
			list.add(k);
			k *= 10; 
			lexicalOrderRec(k, n, list); 
			k /= 10;
			k++; 
			if (k % 10 == 0) return; 
		} 
	}
}
