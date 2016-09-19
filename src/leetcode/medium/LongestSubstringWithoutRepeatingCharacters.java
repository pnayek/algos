package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	
	// O(n), O(1)
	public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int max = 0; // length of longest substring
        int i = 0; int j = 0;
        int count = 0; // count for range [i...j]
        int[] seen = new int[128];
        while (i < n && j < n) {
            int c = s.charAt(j);
            if (seen[c] < i + 1) {
                seen[c] = j + 1;
                count++;
            }
            else {
                max = count > max ? count : max;
                int pos = seen[c];
                i = pos;
                count = j - i + 1;
                seen[c] = j + 1;
            }
            j++;
        }
        max = count > max ? count : max;
        return max;
    }
	
	// O(n), O(n)
	public int lengthOfLongestSubstringSlidingWindowOptimized(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int max = 0; // length of longest substring
        int i = 0; int j = 0;
        int count = 0; // count for range [i...j]
        Map<Character, Integer> seen = new HashMap<Character, Integer>();
        while (i < n && j < n) {
            char c = s.charAt(j);
            if (!seen.containsKey(c) || seen.get(c) < i) {
                seen.put(c, j);
                count++;
            }
            else {
                max = count > max ? count : max;
                int pos = seen.get(c);
                i = pos + 1;
                count = j - i + 1;
                seen.put(c, j);
            }
            j++;
        }
        max = count > max ? count : max;
        return max;
    }
	
	// O(n), O(n)
	public int lengthOfLongestSubstringSlidingWindow(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int max = 0; // length of longest substring
        int i = 0; int j = 0;
        int count = 0; // count for range [i...j]
        Set<Character> seen = new HashSet<Character>();
        while (i < n && j < n) {
            char c = s.charAt(j);
            if (!seen.contains(c)) {
                seen.add(c);
                count++;
            }
            else {
                max = count > max ? count : max;
                seen.remove(s.charAt(i++));
                j--; count--;
            }
            j++;
        }
        max = count > max ? count : max;
        return max;
    }
	
	// O(n^2), O(n)
	public int lengthOfLongestSubstringNaive(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int max = 1;
        Set<Character> seen = new HashSet<Character>(); 
        for (int i = 0; i < n - 1; i++) {
            int count = 1;
            seen.clear();
            seen.add(s.charAt(i));
            for (int j = 1; j < n - i; j++) {
                char c = s.charAt(i + j);
                if (seen.contains(c)) {
                    break;
                }
                seen.add(c);
                count++;
            }
            max = count > max ? count : max;
        }
        return max;
    }
}
