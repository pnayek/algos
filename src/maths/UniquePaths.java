package maths;

public class UniquePaths {
	
	/*
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start').
	 * The robot can only move either down or right at any point in time.
	 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish').
	 * How many possible unique paths are there?
	 * 
	 * Leetcode #62, Medium
	 * 
	 */
	
	// O(min(m, n)), O(1)
	public int uniquePaths(int m, int n) {
        int x = m + n - 2;
        int y = m < n ? m - 1 : n - 1;
        return nCk(x, y);
    }
    
    private int nCk(int n, int k) {
        if (n <= 0 || k <= 0) return 1;
        long res = 1;
        for (int i = 0; i < k; i++) {
            res *= (n - i);
            res /= (i + 1);
        }
        return (int) res;
    }
    
    private int[][] cache;
    
    // O(m + n), O(m * n)
    public int uniquePathsDp(int m, int n) {
        if (m <= 1 || n <= 1) return 1;
        cache = new int[m + 1][n + 1];
        return uniquePathsRec(m, n);
    }
    
    private int uniquePathsRec(int m, int n) {
        if (m <= 1 || n <= 1) return 1;
        if (cache[m][n] > 0) return cache[m][n];
        int ways1 = uniquePathsRec(m - 1, n); // go down
        int ways2 = uniquePathsRec(m, n - 1); // go left
        cache[m][n] = ways1 + ways2;
        if (m < cache[0].length && n < cache.length) {
            cache[n][m] = cache[m][n];
        }
        return cache[m][n];
    }
    
}
