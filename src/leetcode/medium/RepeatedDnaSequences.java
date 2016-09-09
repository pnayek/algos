package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class RepeatedDnaSequences {
	private int char2int(char c) {
        int d = 0;
        if (c == 'C') d = 1;
        else if (c == 'G') d = 2;
        else if (c == 'T') d = 3;
        return d;
    }
    
    private int hash(String s) {
        int h = 0;
        for (int i = 0; i < s.length(); i++) {
            int d = char2int(s.charAt(i));
            h = h * 4 + d;
        }
        return h;
    }
    
    private int hash(int h0, char c, char d) {
        int ci = char2int(c);
        int di = char2int(d);
        int h = ((h0 - ci * (1 << 18)) << 2) + di;
        return h;
    }
        
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        int[] count = new int[2 << 20];
        int l = s.length();
        if (l < 10) return res;
        int h0 = hash(s.substring(0, 10));
        count[h0]++;
        for (int i = 10; i < s.length(); i++) {
            char c = s.charAt(i - 10);
            char d = s.charAt(i);
            int h = hash(h0, c, d);
            //System.out.println("i: " + i + ", h0: " + h0 + ", h: " + h);
            count[h]++;
            if (count[h] == 2) {
                res.add(s.substring(i - 9, i + 1));
            }
            h0 = h;
        }    
        return res;
    }
}
