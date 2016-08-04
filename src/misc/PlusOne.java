package misc;

public class PlusOne {
	/*
	 * Leetcode #66, Easy
	 */
	public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length];
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = carry + digits[i];
            res[i] = sum % 10;
            carry = sum/10;
        }
        if (carry == 0) {
            return res;
        }
        int[] res1 = new int[res.length + 1];
        res1[0] = 1;
        for (int i = 0; i < res.length; i++) {
            res1[i + 1] = res[i];
        }
        return res1;
    }
}
