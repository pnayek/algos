package leetcode.medium;

public class ReverseWordsInAString {
	/*
	 * Given an input string, reverse the string word by word.
	 * For example, Given s = "the sky is blue", return "blue is sky the".
	 * For C programmers: Try to solve it in-place in O(1) space.
	 * 
	 * Clarifications:
	 * 1. A sequence of non-space characters constitutes a word.
	 * 2. The input string may contain leading or trailing spaces.
	 * 3. However, your reversed string should not contain leading or trailing spaces.
	 * If there are multiple spaces between two words, reduce them to a single space in the reversed string.
	 * 
	 * Leetcode #151, Medium
	 * Microsoft, Snapchat, Apple, Bloomberg, Yelp
	 * 
	 */
	
	// O(n), O(n)
	public String reverseWords(String s) {
        String[] vals = s.split("\\s");
        reverse(vals);
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int i = 0; i < vals.length; i++) {
            if (vals[i].isEmpty()) continue;
            if (!first) sb.append(" ");
            else first = false;
            sb.append(vals[i]);
        }
        return sb.toString();
    }
    
    private void reverse(String[] vals) {
        int lo = 0, hi = vals.length - 1;
        while (lo < hi) {
            String temp = vals[lo];
            vals[lo++] = vals[hi];
            vals[hi--] = temp;
        }
    }
}
