package maths;

public class CountNumbersWithUniqueDigits {

	/*
	 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ² x < 10n.
	 * Example: Given n = 2, return 91.
	 * (The answer should be the total numbers in the range of 0 ² x < 100,
	 * excluding [11,22,33,44,55,66,77,88,99])
	 * 
	 * Leetcode #357, Medium
	 */
	public int countNumbersWithUniqueDigits(int n) {
        int sum = 1; // for n = 0, there is one number 0
        for (int i = 1; i <= n; i++) {
            int prod = 9;
            for (int j = 1; j < i; j++) {
                prod *= (10 - j); 
            }
            sum += prod;
        }
        return sum;
    }
	
}
