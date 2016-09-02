package leetcode.medium;

public class SpiralMatrixII {
	
	/*
	 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
	 * 
	 * For example,
	 * Given n = 3,
	 * You should return the following matrix:
	 * [ [ 1, 2, 3 ],
	 *   [ 8, 9, 4 ],
	 *   [ 7, 6, 5 ]
	 * ]
	 * 
	 * Leetcode #59, Medium
	 */
	public static final int RIGHT = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int UP = 3;
    public static final int MOD = 4;
    
    // O(n^2), O(n^2)
	public int[][] generateMatrix(int n) {
		
        int[][] matrix = new int[n][n];
        int direction = RIGHT; // 0 - right, 1 - down, 2 - left, 3 - up
        int i = 1; // elements in the matrix starting with 1
        int x = 0; int y = 0; // position in the matrix
        while (i <= n * n) {
            //System.out.println("M[" + x + "][" + y + "] = " + i + ", dir: " + direction);
            matrix[x][y] = i++;
            switch (direction) {
                case RIGHT:
                    if (y < n - 1 && matrix[x][y + 1] == 0) {
                        y++;
                    }
                    else {
                        x++;
                        direction = (direction + 1) % MOD;
                    }
                    break;
                case DOWN:
                    if (x < n - 1 && matrix[x + 1][y] == 0) {
                        x++;
                    }
                    else {
                        y--;
                        direction = (direction + 1) % MOD;
                    }
                    break;
                case LEFT:
                    if (y > 0 && matrix[x][y - 1] == 0) {
                        y--;
                    }
                    else {
                        x--;
                        direction = (direction + 1) % MOD;
                    }
                    break;
                case UP:
                    if (x > 0 && matrix[x - 1][y] == 0) {
                        x--;
                    }
                    else {
                        y++;
                        direction = (direction + 1) % MOD;
                    }
                    break;
            }
        }
        return matrix;
    }
}
