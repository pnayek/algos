package leetcode.locked;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueWordAbbreviation {

	/*
	 * An abbreviation of a word follows the form <first letter><number><last letter>.
	 * Below are some examples of word abbreviations:

		a) it                      --> it    (no abbreviation)
		
		     1
		b) d|o|g                   --> d1g
		
		              1    1  1
		     1---5----0----5--8
		c) i|nternationalizatio|n  --> i18n
		
		              1
		     1---5----0
		d) l|ocalizatio|n          --> l10n
		Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary.
		A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
		
		Example: 
		Given dictionary = [ "deer", "door", "cake", "card" ]
		
		isUnique("dear") -> 
		false
		
		isUnique("cart") -> 
		true
		
		isUnique("cane") -> 
		false
		
		isUnique("make") -> 
		true
	 *
	 * #288, E
	 * Google
	 */
	
	Map<String, Set<String>> map;
    
    public UniqueWordAbbreviation(String[] dictionary) {
        map = new HashMap<String, Set<String>>();
        for (String word : dictionary) {
            String key = abbrv(word);
            //System.out.println(key + "->" + word);
            put(key, word);
        }
    }

    public boolean isUnique(String word) {
        String key = abbrv(word);
        if (map.containsKey(key)) {
            Set<String> value = map.get(key);
            return value.size() == 1 && value.contains(word);
        }
        return true;
    }
    
    private String abbrv(String word) {
        if (word.length() < 3) return word;
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        sb.append(word.length() - 2);
        sb.append(word.charAt(word.length() - 1));
        return sb.toString();
    }
    
    private void put(String key, String word) {
        Set<String> value;
        if (map.containsKey(key)){
            value = map.get(key);
        }
        else {
            value = new HashSet<String>();
            map.put(key, value);
        }
        value.add(word);
    }
}
