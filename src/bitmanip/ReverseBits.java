package bitmanip;

public class ReverseBits {
	
    public int reverseBits(int n) {
    	// you need to treat n as an unsigned value
        int res = 0;
        for (int count = 0; count < 32; count++) {
            int r = n & 1;
            n = n >>> 1; // so that 0 (and not the sign bit) is always the incoming bit
            res = (res << 1) + r;
        }
        return res;
    }
}
