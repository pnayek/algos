package design;

public class Trie {
	/*
	 * Implement a trie with insert, search, and startsWith methods.
	 * Note: You may assume that all inputs are consist of lowercase letters a-z.
	 * 
	 * Leetcode #208, Medium
	 * Bloomberg, Facebook, Google, Microsoft, Twitter, Uber
	 * 
	 */
	class TrieNode {
	    // Initialize your data structure here.
	    boolean isWord;
	    TrieNode[] children = new TrieNode[26];
	    
	    public TrieNode() {
	    }
	}
	
	private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (p.children[idx] == null) {
                p.children[idx] = new TrieNode();
            }
            p = p.children[idx];
        }
        p.isWord = true;
    }
    
    // Returns if the word is in the trie.
    public boolean search(String word) {
    	TrieNode p = root;
    	for (int i = 0; i < word.length(); i++) {
    		int idx = word.charAt(i) - 'a';
    		if (p.children[idx] == null) return false;
    		p = p.children[idx];
    	}
    	return p.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode p = root;
    	for (int i = 0; i < prefix.length(); i++) {
    		int idx = prefix.charAt(i) - 'a';
    		if (p.children[idx] == null) return false;
    		p = p.children[idx];
    	}
    	return true;
    }
    
    // Returns if the word is in the trie.
    public boolean searchRecurisve(String word) {
        return searchRecursive(word, 0, root);
    }

    private boolean searchRecursive(String word, int start, TrieNode root) {
        if (root == null || word == null || start < 0 || start > word.length()) return false;
        if (start == word.length()) return root.isWord;
        int idx = word.charAt(start) - 'a';
        if (root.children[idx] == null) return false;
        return searchRecursive(word, start + 1, root.children[idx]);
    }
    
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWithRecursive(String prefix) {
        return startsWithRecursive(prefix, 0, root);    
    }
    
    private boolean startsWithRecursive(String prefix, int start, TrieNode root) {
        if (root == null || prefix == null || start < 0 || start > prefix.length()) return false;
        if (start == prefix.length()) return true;
        int idx = prefix.charAt(start) - 'a';
        if (root.children[idx] == null) return false;
        return startsWithRecursive(prefix, start + 1, root.children[idx]);
    }
}
