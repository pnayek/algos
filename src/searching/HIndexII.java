package searching;

public class HIndexII {
	
	/*
	 * Follow up for H-Index:
	 * What if the citations array is sorted in ascending order? Could you optimize your algorithm?
	 * 
	 * Leetcode #275, Medium
	 */
	
	// O(lg n), O(1)
	public int hIndex(int[] citations) {
        int lo = 0;
        int n = citations.length;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (n - mid == citations[mid]) {
                return n - mid;
            }
            else if (n - mid > citations[mid]) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return n - lo; 
    }
}
