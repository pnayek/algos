package dp;

public class IntegerBreak {
	/*
	 * Given a positive integer n, break it into the sum of at least
	 * two positive integers and maximize the product of those integers.
	 * Return the maximum product you can get.
	 * For example, given n = 2, return 1 (2 = 1 + 1);
	 * given n = 10, return 36 (10 = 3 + 3 + 4).
	 * Note: You may assume that n is not less than 2 and not larger than 58.
	 * 
	 * Leetcode #343, Medium
	 */
	
	// O(n^2), O(n)
	public int integerBreak(int n) {
        int[] cache = new int[n + 1];
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = 1;
            for (int j = 1; j <= i/2; j++) {
                int l = cache[j] > j ? cache[j] : j;
                int r = cache[i - j] > (i - j) ? cache[i - j] : (i - j);
                int prod = l * r;
                max = prod > max ? prod : max;
            }
            cache[i] = max;
        }
        return cache[n];
    }
}
