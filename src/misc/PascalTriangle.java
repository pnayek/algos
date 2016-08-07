package misc;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	/*
	 * Given numRows, generate the first numRows of Pascal's triangle.
	 * For example, given numRows = 5,
	 * Return
	 * [
	 *      [1],
	 *     [1,1],
	 *    [1,2,1],
	 *   [1,3,3,1],
	 *  [1,4,6,4,1]
	 * ]
	 * 
	 * Leetcode #118, Easy
	 */
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>(i);
            if (i == 0) list.add(1);
            else {
                list.add(1);
                List<Integer> prev = result.get(i - 1);
                for (int j = 1; j < prev.size(); j++) {
                    list.add(prev.get(j - 1) + prev. get(j));
                }
                list.add(1);
            }
            result.add(list);
        }
        return result;
    }
	
	/*
	 * Given an index k, return the kth row of the Pascal's triangle.
	 * For example, given k = 3, Return [1,3,3,1].
	 * Note: optimize your algorithm to use only O(k) extra space?
	 * 
	 * Leetcode #119, Easy
	 */
	public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        int mid = rowIndex/2;
        for (int i = 0; i < mid; i++) {
            // n C r = (n - r + 1)/(r) * n C (r - 1)
            int x = row.get(i);
            long y = ((long) (rowIndex - i) * (long) x) / (i + 1);
            row.add((int)y);
        }
        for (int i = mid + 1; i < rowIndex + 1; i++) {
            row.add(row.get(rowIndex - i));
        }
        return row;
    }
}
