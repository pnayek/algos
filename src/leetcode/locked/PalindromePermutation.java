package leetcode.locked;

public class PalindromePermutation {

	/*
	 * Given a string, determine if a permutation of the string could form a palindrome.

		For example,
		"code" -> False, "aab" -> True, "carerac" -> True.
		
		Hint:
		
		Consider the palindromes of odd vs even length. What difference do you notice?
		Count the frequency of each character.
		If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
	 *
	 * #266, E
	 * Google, Uber, Bloomberg
	 */
	
	public boolean canPermutePalindrome(String s) {
        int[] counts = new int[128];
        for (char c : s.toCharArray()) {
            counts[c]++;
        }
        boolean oneOdd = false;
        for (int i : counts) {
            if (oneOdd && i % 2 != 0) return false;
            if (i % 2 != 0) oneOdd = true;
        }
        return true;
    }
}
