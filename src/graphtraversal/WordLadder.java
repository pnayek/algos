package graphtraversal;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	/*
	 * Given two words (beginWord and endWord), and a dictionary's word list,
	 * find the length of shortest transformation sequence from beginWord to endWord, such that:
	 * 
	 * Only one letter can be changed at a time
	 * Each intermediate word must exist in the word list
	 * 
	 * For example,
	 * Given: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
	 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
	 * 
	 * Note:
	 * Return 0 if there is no such transformation sequence.
	 * All words have the same length.
	 * All words contain only lowercase alphabetic characters.
	 * 
	 * Leetcode #127, Medium
	 * Amazon, Facebook, LinkedIn, Snapchat, Yelp
	 */
	
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		if (beginWord.equals(endWord)) return 1;
		Set<String> seen = new HashSet<String>();
		Queue<String> q = new LinkedList<String>();
		q.offer(beginWord);
		seen.add(beginWord);
		int count = 1;
		while (!q.isEmpty()) {
			int sz = q.size();
			for (int i = 0; i < sz; i++) {
				String w = q.poll();
				char[] c = w.toCharArray();
				for (int j = 0; j < c.length; j++) {
					for (char d = 'a'; d <= 'z'; d++) {
						c[j] = d;
						String nw = new String(c);
						c[j] = w.charAt(j);
						if (nw.equals(endWord)) return count + 1;
						if (!wordList.contains(nw)) continue;
						if (seen.contains(nw)) continue;
						q.offer(nw);
						seen.add(nw);
					}
				}
			}
			count++;
		}
		return 0;
	}

	public static void main(String[] args) {
		WordLadder wl = new WordLadder();
		String beginWord = "hit";
		String endWord = "cog";
		Set<String> wordList = new HashSet<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		int l = wl.ladderLength(beginWord, endWord, wordList);
		System.out.println(l);
	}
}
