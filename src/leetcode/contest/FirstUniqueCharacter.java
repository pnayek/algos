package leetcode.contest;

public class FirstUniqueCharacter {
	/*
	 * Given a string, find the first non-repeating character in it and return it's index.
	 * If it doesn't exist, return -1. Examples:
	 * s = "leetcode" return 0.
	 * s = "loveleetcode", return 2.
	 * Note: You may assume the string contain only lowercase letters.
	 * 
	 * Leetcode warm up contest #387, Easy
	 */
	
	public int firstUniqChar(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int indx = s.charAt(i) - 'a';
            counts[indx]++;
        }
        for (int i = 0; i < s.length(); i++) {
            int indx = s.charAt(i) - 'a';
            if (counts[indx] == 1) return i;
        }
        return -1;
    }
}
