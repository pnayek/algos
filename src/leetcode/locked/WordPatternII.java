package leetcode.locked;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPatternII {

	/*
	 * Given a pattern and a string str, find if str follows the same pattern.

		Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
		
		Examples:
		pattern = "abab", str = "redblueredblue" should return true.
		pattern = "aaaa", str = "asdasdasdasd" should return true.
		pattern = "aabb", str = "xyzabcxzyabc" should return false.
		Notes:
		You may assume both pattern and str contains only lowercase letters.
	 *
	 * #291, H
	 * Dropbox, Uber
	 */
	
	// 91ms
	public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>();
        Set<String> seen = new HashSet<String>();
        return wordPatternMatch(pattern, str, 0, 0, map, seen);
    }
    
    private boolean wordPatternMatch(String pattern, String str, int pPos, int sPos, Map<Character, String> map, Set<String> set) {
        if (pattern == null && str == null) return true;
        if (pattern == null || str == null) return false;
        if (pPos == pattern.length() && sPos == str.length()) return true;
        if (pPos == pattern.length() || sPos == str.length()) return false;
        char c = pattern.charAt(pPos);
        if (map.containsKey(c)) {
            String sub1 = map.get(c);
            if (!str.startsWith(sub1, sPos)) return false;
            return wordPatternMatch(pattern, str, pPos + 1, sPos + sub1.length(), map, set);
        }
        else {
            for (int end = sPos + 1; end <= str.length(); end++) {
                String sub = str.substring(sPos, end);
                if (set.contains(sub)) continue;
                map.put(c, sub);
                set.add(sub);
                boolean b = wordPatternMatch(pattern, str, pPos + 1, end, map, set);
                if (b) return true;
                map.remove(c);
                set.remove(sub);
            }
            return false;
        }
    }
    
	// 109ms
	public boolean wordPatternMatch1(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>();
        return wordPatternMatch(pattern, str, 0, 0, map);
    }
    
    private boolean wordPatternMatch(String pattern, String str, int pPos, int sPos, Map<Character, String> map) {
        if (pattern == null && str == null) return true;
        if (pattern == null || str == null) return false;
        if (pPos == pattern.length() && sPos == str.length()) return true;
        if (pPos == pattern.length() || sPos == str.length()) return false;
        char c = pattern.charAt(pPos);
        if (map.containsKey(c)) {
            String sub1 = map.get(c);
            if (sub1.length() > str.length() - sPos) return false;
            String sub2 = str.substring(sPos, sPos + sub1.length());
            if (!sub1.equals(sub2)) return false;
            return wordPatternMatch(pattern, str, pPos + 1, sPos + sub1.length(), map);
        }
        else {
            for (int end = sPos + 1; end <= str.length(); end++) {
                String sub = str.substring(sPos, end);
                if (map.containsValue(sub)) continue;
                map.put(c, sub);
                boolean b = wordPatternMatch(pattern, str, pPos + 1, end, map);
                if (b) return true;
                map.remove(c);
            }
            return false;
        }
    }
}
