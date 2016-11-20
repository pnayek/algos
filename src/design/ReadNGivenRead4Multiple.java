package design;

import java.util.ArrayList;
import java.util.List;

public class ReadNGivenRead4Multiple {

	/*
	 * The API: int read4(char *buf) reads 4 characters at a time from a file.
	 * The return value is the actual number of characters read. For example,
	 * it returns 3 if there is only 3 characters left in the file.
	 * By using the read4 API, implement the function int read(char *buf, int n)
	 * that reads n characters from the file.
	 * 
	 * Note: The read function may be called multiple times.
	 * 
	 * Leetcode #158, Hard
	 * Bloomberg, Facebook, Google 
	 */
	
	/* The read4 API is defined in the parent class Reader4. */
    int read4(char[] buf) {
    	// a dummy implementation
    	return 0;
    }
    
	/**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    int idx = 0;
    List<Character> buffer = new ArrayList<Character>();
    
    public int read(char[] buf, int n) {
        int count = 0;
        while (idx < buffer.size() && count < n) {
            buf[count++] = buffer.get(idx++);
        }
        char[] buf4 = new char[4];
        int x = 4;
        while (x == 4 && count < n) {
            x = read4(buf4);
            int min = n - count < x ? n - count : x; 
            for (int i = 0; i < min; i++) {
                buffer.add(buf4[i]);
                buf[count++] = buf4[i];
            }
            idx += min;
            for (int i = min; i < x; i++) {
                buffer.add(buf4[i]);
            }
        }
        return count;
    }
}
