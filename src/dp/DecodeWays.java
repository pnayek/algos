package dp;

public class DecodeWays {
	public int numDecodings(String s) {
        if (s == null || s.isEmpty()) return 0;
        return numDecodings(s, 0);
    }
    
    private int numDecodings(String s, int start) {
        if (start > s.length()) return 0;
        if (start == s.length()) return 1;
        int c = s.charAt(start) - '0';
        int x = 0;
        if (start + 1 < s.length()) {
            int d = s.charAt(start + 1) - '0';
            x = c * 10 + d;
        }
        /*
        if (start == s.length() - 1) {
            // single character
            return c > 0 && c < 10 ? 1 : 0;
        }
        // two characters
        int d = s.charAt(start + 1) - '0';
        int x = c * 10 + d;
        if (start == s.length() - 2) {
            int sum = c > 0 && c < 10 ? 1 : 0;
            sum += x > 9 && x < 27 ? 1 : 0;
            return sum;
        }
        */
        int n1 = c > 0 && c < 10 ? numDecodings(s, start + 1) : 0;
        int n2 = x > 9 && x < 27 ? numDecodings(s, start + 2) : 0;
        //System.out.println("start: " + start + ", n1: " + n1 + ", n2: " + n2);
        return n1 + n2; 
    }
}
