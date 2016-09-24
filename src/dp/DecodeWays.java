package dp;

public class DecodeWays {
	/*
	 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
	 * 'A' -> 1
	 * 'B' -> 2
	 * ...
	 * 'Z' -> 26
	 * 
	 * Given an encoded message containing digits, determine the total number of ways to decode it.
	 * For example,
	 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
	 * The number of ways decoding "12" is 2.
	 * 
	 * Leetcode #91, Medium
	 * Facebook, Microsoft, Uber
	 */
	
	int[] cache;
    
    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) return 0;
        cache = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
            cache[i] = -1;
        return numDecodings(s, 0);
    }
    
    private int numDecodings(String s, int start) {
        if (start > s.length()) return 0;
        if (start == s.length()) return 1;
        if (cache[start] >= 0) return cache[start];
        int c = s.charAt(start) - '0';
        int x = 0;
        if (start + 1 < s.length()) {
            int d = s.charAt(start + 1) - '0';
            x = c * 10 + d;
        }
        int n1 = c > 0 && c < 10 ? numDecodings(s, start + 1) : 0;
        int n2 = x > 9 && x < 27 ? numDecodings(s, start + 2) : 0;
        cache[start] = n1 + n2; 
        return cache[start];
    }
}
