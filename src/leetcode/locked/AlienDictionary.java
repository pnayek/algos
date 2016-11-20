package leetcode.locked;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {

	/*
	 * There is a new alien language which uses the latin alphabet.
	 * However, the order among letters are unknown to you.
	 * You receive a list of words from the dictionary,
	 * where words are sorted lexicographically by the rules of this new language.
	 * Derive the order of letters in this language.

		For example,
		Given the following words in dictionary,
		
		[
		  "wrt",
		  "wrf",
		  "er",
		  "ett",
		  "rftt"
		]
		The correct order is: "wertf".
		
		Note:
		1. You may assume all letters are in lowercase.
		2. If the order is invalid, return an empty string.
		3. There may be multiple valid order of letters, return any one of them is fine.
	 *
	 * #269, H
	 * Google, Airbnb, Facebook, Twitter, PocketGems, Snapchat 
	 */
	
	// 9ms
	public String alienOrder(String[] words) {
        List<Set<Integer>> parents = new ArrayList<Set<Integer>>(26);
        List<Set<Integer>> children = new ArrayList<Set<Integer>>(26);
        for (int i = 0; i < 26; i++) {
            parents.add(new HashSet<Integer>());
            children.add(new HashSet<Integer>());
        }
        Set<Integer> unique = new HashSet<Integer>();
        for (String w : words) {
            for (char c : w.toCharArray()) {
                unique.add(c - 'a');
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int j = 0;
            boolean found = false;
            while (j < w1.length() && j < w2.length()) {
                int u = w1.charAt(j) - 'a';
                if (w1.charAt(j) != w2.charAt(j)) {
                    int v = w2.charAt(j) - 'a';
                    // edge u -> v, parent: u, child: v
                    children.get(u).add(v);
                    parents.get(v).add(u);
                    found = true;
                    break;
                }
                j++;
            }
            if (!found && w2.length() < w1.length()) return "";
        }
        // topological sort on the graph
        // find all nodes that do not have parents
        Queue<Integer> q = new LinkedList<Integer>();
        Set<Integer> seen = new HashSet<Integer>();
        for (int i : unique) {
            if (parents.get(i).isEmpty()) {
                q.offer(i);
                seen.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int u = q.poll();
                sb.append((char) (u + 'a'));
                for (int v : children.get(u)) {
                    //System.out.println("u: " + u + ", v: " + v);
                    if (seen.contains(v)) return "";
                    parents.get(v).remove(u);
                    if (parents.get(v).isEmpty()) {
                        // it can be picked next
                        q.offer(v);
                        seen.add(v);
                    }
                }
            }
        }
        if (sb.length() != unique.size()) return "";
        return sb.toString();
     }
}
