package maths;

public class FactorialTrailingZeroes {
	/*
	 * Leetcode #172, Easy
	 */
	public int trailingZeroes(int n) {
        int f = 5;
        int sum = 0;
        while (f <= n) {
            sum += n/f;
            if (f >= Integer.MAX_VALUE/5) break;
            f *= 5;
        }
        return sum;
    }
	
}
