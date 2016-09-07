package recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
	/*
	 * Given a digit string, return all possible letter combinations that the number could represent.
	 * A mapping of digit to letters (just like on the telephone buttons) is given below.
	 * Input:Digit string "23"
	 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
	 * Note:
	 * Although the above answer is in lexicographical order, your answer could be in any order you want.
	 * 
	 * Leetcode #17, Medium
	 */
	private String[] map = {" ", "", "abc", "def", "ghi", "jkl", "mno",
			"pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		if (digits == null || digits.isEmpty()) return res;
		List<String> sub = letterCombinations(digits.substring(1));
		int index = digits.charAt(0) - '0';
		String chars = map[index];
		for (int i = 0; i < chars.length(); i++) {
			String c = chars.substring(i, i + 1);
			if (sub.isEmpty()) {
				res.add(c);
			}
			else {
				for (String s: sub) {
					res.add(c + s);
				}
			}
		}
		return res;
	}
}
