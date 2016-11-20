package leetcode.locked;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctChars {

	/*
	 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
	 * For example, Given s = “eceba” and k = 2, T is "ece" which its length is 3.
	 * 
	 * #340, H
	 * Google
	 */
	
	// 37ms
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.isEmpty() || k <= 0) return 0; 
        int max = 0, start = 0, i = 0, end = s.length();
        Map<Character, Integer> seen = new HashMap<Character, Integer>();
        while (i < end) {
            char c = s.charAt(i);
            if (!seen.containsKey(c)) {
                //System.out.println("Adding " + c);
                seen.put(c, 1);
            }
            else {
                seen.put(c, seen.get(c) + 1);
            }
            //System.out.println(seen.size());
            while (seen.size() > k) {
                char d = s.charAt(start);
                int v = seen.get(d) - 1;
                if (v == 0) {
                    seen.remove(d);
                }
                else {
                    seen.put(d, v);
                }
                start++;
            }
            i++;
            max = (i - start) > max ? (i - start) : max;
        }
        return max;
    }
}
