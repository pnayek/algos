package leetcode.medium;

public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return s;
        int l = s.length();
        int max = 1, start = 0, end = 1;
        for (int i = 0; i < 2 * l - 1; i++) {
            if (i % 2 == 0) {
                // center is the character at s[i/2]
                int j = i/2, n = 1;
                for (int r = 1; j - r >= 0 && j + r < l; r++) {
                    if (s.charAt(j - r) != s.charAt(j + r)) {
                        break;
                    }
                    n += 2;
                }
                if (n > max) {
                    max = n;
                    start = j - (n/2);
                    end = j + (n/2) + 1;
                }
            }
            else {
                // center is between s[i/2] and s[i/2 + 1]
                int j = i/2;
                int n = 0;
                for (int r = 0; j - r >= 0 && j + 1 + r < l; r++) {
                    if (s.charAt(j - r) != s.charAt(j + 1 + r)) {
                        break;
                    }
                    n += 2;
                }
                if (n > max) {
                    max = n;
                    start = j - (n/2) + 1;
                    end = j + (n/2) + 1;
                }
            }
        }
        return s.substring(start, end);
    }
	
	public static void main(String[] args) {
		String s = "bb";
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome(s));
	}
}
