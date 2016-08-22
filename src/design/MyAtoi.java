package design;

public class MyAtoi {
	/*
	 * Requirements:
	 * 1. For null and empty string return 0
	 * 2. There can be leading and trailing white spaces -- ignore them
	 * 3. There can be a sign character in the beginning -- + or -
	 * 4. If the string has a prefix that is a valid integer followed by garbage, return the valid integer
	 * 5. If the value of the number is outside integer bounds (MAX_ALUE, MIN_VALUE) return the bounds
	 * 6. In all other erroneous cases return 0
	 */
	public int myAtoi(String str) {
        if (str == null) return 0;
        str = str.trim(); // remove trailing and leading whitespaces
        if (str.isEmpty()) return 0;
        if (str.charAt(0) == '-') {
            // negative number
            return myAtoiWithSign(str.substring(1), true);
        }
        else if (str.charAt(0) == '+') {
            // positive number
            return myAtoiWithSign(str.substring(1), false);
        }
        return myAtoiWithSign(str, false);
    }
    
    private int myAtoiWithSign(String str, boolean isNegative) {
        long res = 0;
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - '0';
            if (c < 0 || c > 9) break;
            res = isNegative ? res * 10 - c : res * 10 + c;
            if (!isNegative && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (isNegative && res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int) res;
    }
}
