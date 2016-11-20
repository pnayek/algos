package leetcode.locked;

public class RangeSumQuery2dMutable {

	/*
	 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle
	 * defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
	 * 
	 * Example:
		Given matrix = [
		  [3, 0, 1, 4, 2],
		  [5, 6, 3, 2, 1],
		  [1, 2, 0, 1, 5],
		  [4, 1, 0, 1, 7],
		  [1, 0, 3, 0, 5]
		]
		
		sumRegion(2, 1, 4, 3) -> 8
		update(3, 2, 2)
		sumRegion(2, 1, 4, 3) -> 10
		Note:
		1. The matrix is only modifiable by the update function.
		2. You may assume the number of calls to update and sumRegion function is distributed evenly.
		3. You may assume that row1 ² row2 and col1 ² col2.
		
	 * #308, H
	 * Google
	 */
	
	int[][] bit;
    int[][] matrix;
    
    public RangeSumQuery2dMutable(int[][] matrix) {
        this.matrix = matrix;
        if (matrix.length != 0 && matrix[0].length != 0) {
            int m = matrix.length, n = matrix[0].length;
            bit = new int[m][n + 1];
            createTrees();
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        matrix[row][col] = val;
        updateTree(row, col + 1, diff);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += sumRange(i, col1, col2);
        }
        return sum;
    }
    
    private void createTrees() {
        for (int i = 0; i < bit.length; i++) {
            createTree(i);
        }
    }
    
    private void createTree(int i) {
        int[] row = matrix[i];
        for (int idx = 0; idx < row.length; idx++) {
            updateTree(i, idx + 1, row[idx]);
        }
    }
    
    private void updateTree(int i, int idx, int val) {
        while (idx < bit[i].length) {
            bit[i][idx] += val;
            idx += (idx & (-idx));
        }
    }
    
    private int sumRange(int row, int col1, int col2) {
        int sum1 = prefixSum(row, col1); // returns 0 ... col1 - 1
        int sum2 = prefixSum(row, col2 + 1); // returns sum 0 ... col2
        return sum2 - sum1;
    }
    
    private int prefixSum(int row, int idx) {
        if (idx <= 0) return 0;
        int sum = 0;
        while (idx > 0) {
            sum += bit[row][idx];
            idx -= (idx & -idx);
        }
        return sum;
    }
}
