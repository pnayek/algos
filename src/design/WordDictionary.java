package design;

import java.util.LinkedList;
import java.util.Queue;

public class WordDictionary {
	/*
	 * Design a data structure that supports the following two operations:
	 * void addWord(word)
	 * bool search(word)
	 * 
	 * search(word) can search a literal word or a regular expression string containing only letters a-z or .
	 * A . means it can represent any one letter.
	 * 
	 * For example:
	 * addWord("bad")
	 * addWord("dad")
	 * addWord("mad")
	 * search("pad") -> false
	 * search("bad") -> true
	 * search(".ad") -> true
	 * search("b..") -> true
	 * Note: You may assume that all words are consist of lowercase letters a-z.
	 * 
	 * Leetcode #211, Medium
	 * Facebook
	 */
	public class TrieNode {
        char c;
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
        
        public TrieNode(char c) {
            this.c = c;
        }
        
        public void print(int l) {
        	for (int i = 0; i < l; i++)
        		System.out.print("\t");
        	System.out.println(c + ", " + isWord);
        	for (TrieNode p : children) {
        		if (p != null) p.print(l + 1);
        	}
        }
    }

    TrieNode root;
    
    public WordDictionary() {
        // create the root of Trie
        root = new TrieNode('#');
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            p.children[index] = p.children[index] == null ? new TrieNode(c) : p.children[index];
            p.children[index].isWord = (i == word.length() - 1);
            p = p.children[index];
        }
        //root.print(0);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // BFS
        Queue<TrieNode> queue = new LinkedList<TrieNode>();
        queue.offer(root);
        int i = 0;
        while (!queue.isEmpty() && i < word.length()) {
        	int size = queue.size();
            for (int j = 0; j < size; j++) {
                TrieNode n = queue.poll();
                char c = word.charAt(i);
                System.out.println("c: " + c + ", i: " + i);
                if (c == '.') {
                    // any valid character a - z
                    for (TrieNode p: n.children) {
                        if (p != null) {
                            if (i == word.length() - 1 && p.isWord) return true;
                            queue.offer(p);
                        }
                    }
                }
                else {
                    int index = c - 'a';
                    TrieNode p = n.children[index];
                    if (p != null) {
                        if (i == word.length() - 1 && p.isWord) return true;
                        queue.offer(p);
                    }
                }
            }
            i++;
        }
        return false;
    }
    
    public static void main(String[] args) {
    	  WordDictionary wordDictionary = new WordDictionary();
    	  wordDictionary.addWord("at");
    	  wordDictionary.addWord("and");
    	  wordDictionary.addWord("an");
    	  wordDictionary.addWord("add");
    	  //System.out.println("searching a: " + wordDictionary.search("a"));
    	  //System.out.println("searching .at: " + wordDictionary.search(".at"));
    	  wordDictionary.addWord("bat");
    	  //System.out.println("searching .at: " + wordDictionary.search(".at"));
    	  //System.out.println("searching an.: " + wordDictionary.search("an."));
    	  //System.out.println("searching a.d.: " + wordDictionary.search("a.d."));
    	  //System.out.println("searching b.: " + wordDictionary.search("b."));
    	  System.out.println("searching a.d: " + wordDictionary.search("a.d"));
    	  System.out.println("searching .: " + wordDictionary.search("."));
    }
 
}
