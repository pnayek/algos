package dp;

import java.util.Set;

public class WordBreak {
	/*
	 * Given a string s and a dictionary of words dict,
	 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
	 * For example, given s = "leetcode", dict = ["leet", "code"].
	 * 
	 * Return true because "leetcode" can be segmented as "leet code".
	 * 
	 * Leetcode #139, Medium
	 * Google, Uber, Facebook, Amazon, Yahoo, Bloomberg, Pocket Gems
	 */
	private int[] cache;

	public boolean wordBreak(String s, Set<String> wordDict) {
		cache = new int[s.length() + 1]; // default all 0s
		return wordBreak(s, 0, wordDict);       
	}

	public boolean wordBreak(String s, int start, Set<String> wordDict) {
		if (cache[start] == 1) {
			return true;
		}
		else if (cache[start] == -1) {
			return false;
		} 
		if (wordDict.contains(s.substring(start))) {
			cache[start] = 1;
			return true;
		}
		for (int i = start; i < s.length() - 1; i++) {
			String sub1 = s.substring(start, i + 1);
			if (wordDict.contains(sub1)) {
				if (wordBreak(s, i + 1, wordDict)) {
					cache[i + 1] = 1;
					return true;
				}
			}
		}
		cache[start] = -1;
		return false;
	}
}
