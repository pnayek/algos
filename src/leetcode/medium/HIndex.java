package leetcode.medium;

import java.util.Arrays;

public class HIndex {
	/*
	 * Given an array of citations (each citation is a non-negative integer) of a researcher,
	 * write a function to compute the researcher's h-index.
	 * 
	 * According to the definition of h-index on Wikipedia:
	 * "A scientist has index h if h of his/her N papers have at least h citations each, 
	 * and the other N − h papers have no more than h citations each."
	 * 
	 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers
	 * in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
	 * 
	 * Since the researcher has 3 papers with at least 3 citations each and the remaining two
	 * with no more than 3 citations each, his h-index is 3.
	 * 
	 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
	 * 
	 * Leetcode #274, Medium
	 * 
	 */
	
	// O(n), O(n)
	public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0) return 0;
        int[] counts = new int[n + 1];
        for (int i: citations) {
            i = i < n ? i : n;
            counts[i]++;
        }
        int sum = 0;
        for (int i = n; i > 0; i--) {
            sum += counts[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
	
	// O(n lg n), O(1)
	public int hIndexSort(int[] citations) {
        int n = citations.length;
        if (n == 0) return 0;
        Arrays.sort(citations);
        int j = 1;
        while (j <= n && citations[n - j] >= j) {
            j++;
        }
        return j - 1;
    }
	
	// O(n^2), O(n)
	public int hIndexCumulative(int[] citations) {
        int max = 0;
        for (int i: citations) {
            max = i > max ? i : max;
        }
        int[] cumCounts = new int[max + 1];
        for (int i: citations) {
            for (int j = i; j >= 0; j--) {
                cumCounts[j]++;
            }
        }
        for (int i = max; i > 0; i--) {
            if (cumCounts[i] >= i) {
                return i;
            }
        }
        return 0;
    }
}
