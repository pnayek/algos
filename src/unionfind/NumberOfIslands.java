package unionfind;

public class NumberOfIslands {
	/*
	 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
	 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
	 * You may assume all four edges of the grid are all surrounded by water.
	 * 
	 * Example 1:
	 * 11110
	 * 11010
	 * 11000
	 * 00000
	 * Answer: 1
	 * 
	 * Example 2:
	 * 11000
	 * 11000
	 * 00100
	 * 00011
	 * Answer: 3
	 * 
	 * Leetcode #200, Medium
	 */
	
	private int[] id; // parents of nodes
    private int[] size; // sizes of connected components
    private int count = 0; // no of connected components
    
    private int root(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
    
    // quick weighted union using path compression 
    private void union(int p, int q) {
        int r1 = root(p);
        int r2 = root(q);
        
        // do a path compression
        id[p] = r1;
        id[q] = r2;
        
        if (r1 == r2) return;
            
        // weighted union
        if (size[r1] <= size[r2]) {
            // make r2 subtree of r1 with path compression
            id[q] = id[r2] = r1;
            size[r1] += size[r2];
        }
        else {
            // make r2 subtree of r1 with path compression
            id[p] = id[r1] = r2;
            size[r2] += size[r1];
        }
        count--;
    }
    
    public int numIslands(char[][] grid) {
        // union find using weighted quick union approach
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        //System.out.println("m: " + m + ", n: " + n);
        id = new int[m * n];
        size = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //System.out.println("i: " + i + ", j: " + j);
                if (grid[i][j] == '1') {
                    id[n * i + j] = n * i + j;
                    size[n * i + j] = 1;
                    count++;
                }
                else {
                    id[n * i + j] = -1;
                }
            }
        }
        //System.out.println(count);
        // perform the union operations
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (j < n - 1 && grid[i][j + 1] == '1') {
                        // horizontal connection
                        union(n * i + j, n * i + j + 1);
                    }
                    if (i < m - 1 && grid[i + 1][j] == '1') {
                        // vertical connection
                        union(n * i + j, n * (i + 1) + j);
                    }
                }
            }
        }
        return count;
    }
}
