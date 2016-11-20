package leetcode.locked;

public class OneEditDistance {

	/*
	 * Given two strings S and T, determine if they are both one edit distance apart.
	 * 
	 * #161, M
	 * Snapchat, Uber, Facebook, Twitter
	 */
	
	// 3ms
	public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null || s.equals(t)) return false;
        int diff = Math.abs(s.length() - t.length());
        if (diff > 1) return false;
        if (diff == 0) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) count++;
                if (count == 2) return false;
            }
        }
        else {
            int count = 0;
            String min = s.length() < t.length() ? s : t;
            String max = s.length() < t.length() ? t : s;
            for (int i = 0; i < max.length(); i++) {
                if (i - count >= min.length() || max.charAt(i) != min.charAt(i - count)) {
                    count++;
                }
                if (count == 2) return false;
            }
        }
        return true;
    }
}
