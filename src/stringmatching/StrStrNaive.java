package stringmatching;

public class StrStrNaive {

	public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (needle.isEmpty()) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean success = true;
                for (int j = 1; j < needle.length(); j++) {
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
