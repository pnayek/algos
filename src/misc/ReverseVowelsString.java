package misc;

public class ReverseVowelsString {
	
	private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
    
    public String reverseVowels(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) return s;
        char[] chars = s.toCharArray();
        int start = 0; int end = s.length() - 1;
        while (start < end) {
            // advance start to a vowel location
            while (start < end && !isVowel(chars[start])) {
                start++;
            }
            // move end to a vowel location
            while (start < end && !isVowel(chars[end])) {
                end--;
            }
            if (start < end && isVowel(chars[start]) && isVowel(chars[end])) {
                char c = chars[start];
                chars[start] = chars[end];
                chars[end] = c;
                start++; end--;
            }
        }
        return new String(chars);
    }
}
