package design;

public class ReadNGivenRead4 {
/*
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read.
 * For example, it returns 3 if there is only 3 characters left in the file.
 * 
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * Note: The read function will only be called once for each test case.
 * 
 * Leetcode #157, Easy
 * Facebook
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
    public int read(char[] buf, int n) {
        char[] buf4 = new char[4];
        int count = 0, count4 = 4;
        while (count < n && count4 == 4) {
            count4 = read4(buf4);
            int x = n - count < count4 ? n - count : count4;
            for (int i = 0; i < x; i++) {
                buf[count + i] = buf4[i];
            }
            count += x;
        }
        return count;
    }
}
