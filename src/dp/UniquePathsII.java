package dp;

public class UniquePathsII {
	/*
	 * Follow up for "Unique Paths":
	 * Now consider if some obstacles are added to the grids.
	 * How many unique paths would there be?
	 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
	 * For example, There is one obstacle in the middle of a 3x3 grid as illustrated below.
	 * [ [0,0,0],
	 *   [0,1,0],
	 *   [0,0,0]
	 * ]
	 * The total number of unique paths is 2. Note: m and n will be at most 100.
	 * 
	 * Leetcode #63, Medium
	 */

	private int[][] cache;

	private int upwo(int[][] grid, int x, int y) {
		if (cache[x][y] >= 0) return cache[x][y];
		if (grid[x][y] == 1) return 0;
		int m = cache.length;
		int n = cache[0].length;
		if (x == m - 1 && y == n - 1) return 1;
		int n1 = x < m - 1 ? upwo(grid, x + 1, y) : 0;
		int n2 = y < n - 1 ? upwo(grid, x, y + 1) : 0;
		cache[x][y] = n1 + n2;
		return cache[x][y];
	}

	// O(m * n), O(m * n)
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		cache = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				cache[i][j] = -1;
			}
		}
		cache[0][0] = upwo(obstacleGrid, 0, 0);
		return cache[0][0];
	}
}
