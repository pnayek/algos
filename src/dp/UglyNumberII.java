package dp;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class UglyNumberII {
	/*
	 * Write a program to find the n-th ugly number.
	 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
	 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
	 * Note that 1 is typically treated as an ugly number.
	 * 
	 * Leetcode #264, Medium
	 */

	// O(n), O(n)
	public int nthUglyNumber(int n) {
		int[] res = new int[n];
		res[0] = 1;
		int i = 1;
		int p1 = 0, p2 = 0, p3 = 0;
		while (i < n) {
			int e1 = res[p1] * 2;
			int e2 = res[p2] * 3;
			int e3 = res[p3] * 5;
			int min = 0;
			if (e1 <= e2 && e1 <= e3) {
				min = e1;
				p1++;
			}
			if (e2 <= e1 && e2 <= e3) {
				min = e2;
				p2++;
			}
			if (e3 <= e1 && e3 <= e2) {
				min = e3;
				p3++;
			}
			res[i++] = min;
		}
		return res[n - 1];
	}

	public int nthUglyNumberPriorityQueue(int n) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		Set<Integer> seen = new HashSet<Integer>();
		pq.offer(1);
		seen.add(1);
		int count = 0;
		while (count < n) {
			int e = pq.poll();
			count++;
			if (count == n) return e;
			if (e <= Integer.MAX_VALUE/2 && !seen.contains(e * 2)) {
				pq.offer(e * 2);
				seen.add(e * 2);
			}
			if (e <= Integer.MAX_VALUE/3 && !seen.contains(e * 3)) {
				pq.offer(e * 3);
				seen.add(e * 3);
			}
			if (e <= Integer.MAX_VALUE/5 && !seen.contains(e * 5)) {
				pq.offer(e * 5);
				seen.add(e * 5);
			}
		}
		return 0;
	}

}
