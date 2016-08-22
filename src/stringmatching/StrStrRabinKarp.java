package stringmatching;

public class StrStrRabinKarp {

	private static long hash(String s, int l) {
        long sum = 0;
        for (int i = 0; i < l; i++) {
            sum += s.charAt(i);
        }
        return sum;
    }
    
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) return -1;
        if (needle.isEmpty()) return 0;
        
        // build hashes for all substrings of haystack of length equal to that of needle 
        long[] hashes = new long[haystack.length() - needle.length() + 1];
        for (int i = 0; i < hashes.length; i++) {
            if (i == 0) {
                hashes[0] = hash(haystack, needle.length());
            }
            else {
                hashes[i] = hashes[i - 1] - haystack.charAt(i - 1) + haystack.charAt(i + needle.length() - 1);
            }
        }
        
        long targetHash = hash(needle, needle.length());
        
        for (int i = 0; i < hashes.length; i++) {
            if (hashes[i] == targetHash) {
                // probable candidate
                boolean success = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        success = false;
                        break;
                    }
                }
                if (success) {
                    return i;
                }
            }
        }
        return -1;
    }
}
