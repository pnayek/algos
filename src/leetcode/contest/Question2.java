package leetcode.contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question2 {
	public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<String>();
        if (num <= 0) return res;
        for (int i = 0; i < 4 && i <= num; i++) {
            int j = num - i;
            if (j >= 6) continue; 
            // i bits are set for hours
            // j bits are set for minutes
            List<String> hrs = getHours(i);
            List<String> mins = getMins(j);
            for (String h: hrs) {
                for (String m: mins) {
                    res.add(h + ":" + m);
                }
            }
        }
        return res;
    }
    
    private List<String> getHours(int h) {
        List<String> res = new ArrayList<String>();
        if (h == 0) {
            res.add("0");
        }
        else if (h == 1) {
            res.add("1");
            res.add("2");
            res.add("4");
            res.add("8");
        }
        else if (h == 2) {
            res.add("3");
            res.add("5");
            res.add("6");
            res.add("9");
            res.add("10");
        }
        else {
            res.add("7");
            res.add("11");
        }
        return res;
    }
    
    private int countSetBits(int x) {
        int count = 0;
        while (x > 0) {
            count += (x & 1);
            x >>= 1; 
        }
        return count;
    }
    
    private List<String> getMins(int m) {
        List<String> res = new ArrayList<String>();
        if (m == 0) {
            res.add("0");
        }
        else if (m == 1) {
            res.add("01");
            res.add("02");
            res.add("04");
            res.add("08");
            res.add("16");
            res.add("32");
        }
        else if (m == 5) {
            res.add("59");
            res.add("55");
            res.add("47");
            res.add("31");
        }
        else {
            Set<Integer> seen = new HashSet<Integer>();
            seen.add(1);
            seen.add(2);
            seen.add(4);
            seen.add(8);
            seen.add(16);
            seen.add(32);
            seen.add(59);
            seen.add(55);
            seen.add(47);
            seen.add(31);
            for (int i = 0; i < 60; i++) {
                if (seen.contains(i)) continue;
                int count = countSetBits(i);
                if (count == m) {
                    if (i < 10) {
                        res.add("0" + i);
                    }
                    else {
                        res.add("" + i);
                    }
                }
            }
        }
        return res;
    }
}
