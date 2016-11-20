package leetcode.locked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {

	/*
	 * Given a string, we can "shift" each of its letter to its successive letter,
	 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

		"abc" -> "bcd" -> ... -> "xyz"
		Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
		
		For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
		A solution is:
		
		[
		  ["abc","bcd","xyz"],
		  ["az","ba"],
		  ["acef"],
		  ["a","z"]
		]
	 *
	 * #249, E
	 * Google, Uber
	 */
	
	public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<List<Integer>, List<String>> map = new HashMap<List<Integer>, List<String>>(); // string to list id
        for (String s: strings) {
            List<Integer> h = getHash(s);
            List<String> l = map.get(h);
            if (l == null) {
                l = new ArrayList<String>();
                map.put(h, l);
            }
            l.add(s);
        }
        res.addAll(map.values());
        return res;
    }
    
    private List<Integer> getHash(String s) {
        List<Integer> l = new ArrayList<Integer>();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length - 1; i++) {
            int diff = (26 + c[i + 1] - c[i]) % 26;
            l.add(diff);
        }
        return l;
    }
}
