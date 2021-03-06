package dp;

public class ClimbingStairs {
	/*
	 * You are climbing a stair case.
	 * It takes n steps to reach to the top.
	 * Each time you can either climb 1 or 2 steps. 
	 * In how many distinct ways can you climb to the top?
	 * Leetcode #70, Easy
	 */
	public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n <= 2) return n;
        int[] ways = new int[n + 1];
        ways[0] = 0; ways[1] = 1; ways[2] = 2;
        for (int i = 3; i <= n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[n];
    }
	
	/*
	 * You are climbing a stair case.
	 * It takes n steps to reach to the top.
	 * Each time you can either climb 1, 2 or 3 steps. 
	 * In how many distinct ways can you climb to the top?
	 * CtCI, 8.1
	 */
	public int tripleStep(int n) {
        if (n <= 0) return 0;
        if (n <= 2) return n;
        int[] ways = new int[n + 1];
        ways[0] = 0; ways[1] = 1; ways[2] = 2;
        ways[3] = 4; // (1, 1, 1), (1, 2), (2, 1), (3)
        for (int i = 4; i <= n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2] + ways[i - 3];
        }
        return ways[n];
    }
}
