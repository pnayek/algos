package stringmatching;

public class StrStrKMP {
	private static int[] computePrefixFunction(String needle) {
        int[] pie = new int[needle.length() + 1];
        pie[0] = pie[1] = 0;
        int k = 0;
        for (int i = 2; i < needle.length() + 1; i++) {
            while (k > 0 && needle.charAt(i - 1) != needle.charAt(k)) {
                k = pie[k];
            }
            if (needle.charAt(i - 1) == needle.charAt(k)) {
                k++;
            }
            pie[i] = k;
        }
        return pie;
    }
    
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) return -1;
        if (needle.isEmpty()) return 0;
        
        // build prefix function
        // pie[q] entry keeps the longest prefix of needle[1...q]
        // that is also a proper suffix of needle[1...q]
        int[] pie = computePrefixFunction(needle);
        
        int k = 0; // number of characters in needle that has matched
        for (int i = 0; i < haystack.length(); i++) {
            while (k > 0 && haystack.charAt(i) != needle.charAt(k)) {
                k = pie[k];
            }
            if (needle.charAt(k) == haystack.charAt(i)) {
                k++;
            }
            if (k == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }
}
