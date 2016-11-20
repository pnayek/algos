package leetcode.locked;

public class PaintHouseII {

	/*
	 * There are a row of n houses, each house can be painted with one of the k colors.
	 * The cost of painting each house with a certain color is different.
	 * You have to paint all the houses such that no two adjacent houses have the same color.
	 * The cost of painting each house with a certain color is represented by a n x k cost matrix.
	 * For example, costs[0][0] is the cost of painting house 0 with color 0;
	 * costs[1][2] is the cost of painting house 1 with color 2, and so on...
	 * Find the minimum cost to paint all houses.
	 * Note: All costs are positive integers.
	 * Follow up: Could you solve it in O(nk) runtime?
	 * 
	 * #265, H
	 * Facebook
	 */
	
	public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        cache = new int[costs.length][costs[0].length + 1];
        return minCost(costs, 0, 0);
    }
    
    private int[][] cache;
    private int minCost(int[][] costs, int startN, int excludeK) {
        int n = costs.length;
        int k = costs[0].length;
        if (startN >= n) return 0;
        if (cache[startN][excludeK] != 0) return cache[startN][excludeK]; 
        if (startN == n - 1) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (j + 1 == excludeK) continue;
                min = costs[startN][j] < min ? costs[startN][j] : min;
            }
            cache[startN][excludeK] = min;
            return min;
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            if (j + 1 == excludeK) continue;
            int cost = costs[startN][j] + minCost(costs, startN + 1, j + 1);
            min = cost < min ? cost : min;
        }
        cache[startN][excludeK] = min;
        return min;
    }
}
