package recursion;

public class UglyNumber {
	/*
	 * Write a program to check whether a given number is an ugly number.
	 * Ugly numbers are positive numbers whose prime factors only
	 * include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly 
	 * since it includes another prime factor 7.
	 * Note that 1 is typically treated as an ugly number.
	 * Leetcode #263, Easy
	 */
	public boolean isUgly(int num) {
        if (num <= 0) return false;
        else if (num == 1) return true;
        else if (num % 5 == 0) return isUgly(num/5);
        else if (num % 3 == 0) return isUgly(num/3);
        else if (num % 2 == 0) return isUgly(num/2);
        else return false;
    }
}
