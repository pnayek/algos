package leetcode.locked;

public class ReverseWordsStringII {

	/*
	 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
		
		The input string does not contain leading or trailing spaces and the words are always separated by a single space.
		
		For example,
		Given s = "the sky is blue",
		return "blue is sky the".
		
		Could you do it in-place without allocating extra space?
		
		Related problem: Rotate Array
	 *
	 * #186, M
	 * Amazon, Microsoft, Uber
	 */
	
	public void reverseWords(char[] s) {
        // reverse the whole string
        int n = s.length;
        reverse(s, 0, n - 1);
        // reverse each word
        int lo = 0, hi = 0;
        while (hi < n) {
            // increment hi till you get a space
            while (s[hi] != ' ') {
                hi++;
                if (hi == n) {
                    break;
                }
            }
            reverse(s, lo, hi - 1);
            lo = ++hi;
        }
        // one last reverse
        reverse(s, lo, hi - 1);
    }
    
    private void reverse(char[] s, int lo, int hi) {
        while (lo < hi) {
            char c = s[lo];
            s[lo] = s[hi];
            s[hi] = c;
            lo++; hi--;
        }
    }
}
