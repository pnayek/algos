package bitmanip;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	/*
	 * The gray code is a binary numeral system where two successive values differ in only one bit.
	 * Given a non-negative integer n representing the total number of bits in the code,
	 * print the sequence of gray code. A gray code sequence must begin with 0.
	 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
	 * 00 - 0
	 * 01 - 1
	 * 11 - 3
	 * 10 - 2
	 * Note:
	 * For a given n, a gray code sequence is not uniquely defined.
	 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
	 *
	 * Leetcode #89, Medium
	 */

	public List<Integer> grayCode(int n) {
        int size = (1 << n);
        List<Integer> codes = new ArrayList<Integer>();
        boolean[] seen = new boolean[size];
        int code = 0;
        codes.add(code);
        seen[code] = true;
        while (codes.size() < size) {
            int mask = 1;
            int newCode = code ^ mask;
            while (seen[newCode]) {
                newCode = code ^ mask;
                mask <<= 1;
            }
            code = newCode;
            codes.add(code);
            seen[code] = true;
        }
        return codes;
    }

}
