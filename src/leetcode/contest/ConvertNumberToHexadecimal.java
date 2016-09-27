package leetcode.contest;

public class ConvertNumberToHexadecimal {

	/*
	 * Given an integer, write an algorithm to convert it to hexadecimal.
	 * For negative integer, two’s complement method is used.
	 * 
	 * IMPORTANT:
	 * You must not use any method provided by the library which converts/formats the number to hex directly.
	 * Such solution will result in disqualification of all your submissions to this problem.
	 * Users may report such solutions after the contest ends and we reserve the right of final decision
	 * and interpretation in the case of reported solutions.
	 * 
	 * Note:
	 * All letters in hexadecimal (a-f) must be in lowercase.
	 * The hexadecimal string must not contain extra leading 0s.
	 * If the number is zero, it is represented by a single zero character '0';
	 * otherwise, the first character in the hexadecimal string will not be the zero character.
	 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
	 * You must not use any method provided by the library which converts/formats the number to hex directly.
	 * 
	 * Example 1:
	 * Input: 26 Output: "1a"
	 * Example 2:
	 * Input: -1 Output: "ffffffff"
	 * 
	 * Leetcode #405, Easy
	 * 
	 */
	
	public String toHex(int num) {
        int[] val = new int[8];
        for (int i = 0; i < 8; i++) {
            val[7 - i] = num & 15;
            num >>= 4;
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i: val) {
            if (flag && i == 0) continue;
            flag = false;
            if (i < 10) {
                sb.append(i);
            }
            else {
                sb.append((char) ('a' + i - 10));
            }
        }
        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}
