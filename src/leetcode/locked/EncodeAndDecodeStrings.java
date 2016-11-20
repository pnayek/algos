package leetcode.locked;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

	/*
	 * Design an algorithm to encode a list of strings to a string.
	 * The encoded string is then sent over the network and is decoded back to the original list of strings.
	 * 
	 * Machine 1 (sender) has the function:
		string encode(vector<string> strs) {
		  // ... your code
		  return encoded_string;
		}
		Machine 2 (receiver) has the function:
		vector<string> decode(string s) {
		  //... your code
		  return strs;
		}
		So Machine 1 does:
		
		string encoded_string = encode(strs);
		and Machine 2 does:
		
		vector<string> strs2 = decode(encoded_string);
		strs2 in Machine 2 should be the same as strs in Machine 1.
		
		Implement the encode and decode methods.
		
		Note:
		The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
		Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
		Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
	 *
	 * #271, M
	 * Google
	 */
	
	// Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        // len1#str1len2#str2...
        if (strs == null) return null;
        if (strs.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < strs.size(); j++) {
            String str = strs.get(j);
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s == null) return null;
        List<String> res = new ArrayList<String>();
        if (s.isEmpty()) return res;
        int idx = 0;
        while (idx < s.length()) {
            int lenIdx = s.indexOf('#', idx);
            String lenStr = s.substring(idx, lenIdx);
            int len = Integer.parseInt(lenStr);
            idx = lenIdx + 1 + len;
            res.add(s.substring(lenIdx + 1, idx));
        }
        return res;
    }
}
