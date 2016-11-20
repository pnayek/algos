package leetcode.locked;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsII {

	/*
	 * A 2d grid map of m rows and n columns is initially filled with water.
	 * We may perform an addLand operation which turns the water at position (row, col) into a land.
	 * Given a list of positions to operate, count the number of islands after each addLand operation.
	 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
	 * You may assume all four edges of the grid are all surrounded by water.

		Example:
		
		Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
		Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
		
		0 0 0
		0 0 0
		0 0 0
		Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
		
		1 0 0
		0 0 0   Number of islands = 1
		0 0 0
		Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
		
		1 1 0
		0 0 0   Number of islands = 1
		0 0 0
		Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
		
		1 1 0
		0 0 1   Number of islands = 2
		0 0 0
		Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
		
		1 1 0
		0 0 1   Number of islands = 3
		0 1 0
		We return the result as an array: [1, 1, 2, 3]
		
		Challenge:
		Can you do it in time complexity O(k log mn), where k is the length of the positions?
	 *
	 * #305, H
	 * Google
	 */
	
	public class QUFPC {
        int[] parents, sizes;
        int m, n, numIslands;
        int[][] grid;
        
        public QUFPC (int m, int n) {
            this.m = m;
            this.n = n;
            parents = new int[m * n];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = -1;
            }
            sizes = new int[m * n]; // all 0s by default
            numIslands = 0;
            grid = new int[m][n]; // all 0s by default
        }
        
        public void addLand(int x, int y) {
            if (grid[x][y] == 1) {
                // already a land do nothing
                return;
            }
            grid[x][y] = 1;
            int idx = convert(x, y);
            parents[idx] = idx; sizes[idx] = 1; numIslands++;
            // look for neighbors
            // right
            if (y + 1 < n && grid[x][y + 1] == 1) {
                union(idx, idx + 1);
            }
            // left
            if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                union(idx, idx - 1);
            }
            // up
            if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                union(idx, idx - n);
            }
            // down
            if (x + 1 < m && grid[x + 1][y] == 1) {
                union(idx, idx + n);
            }
        }
        
        private void union(int id1, int id2) {
            int r1 = root(id1);
            int r2 = root(id2);
            parents[id1] = r1;
            parents[id2] = r2;
            if (r1 == r2) {
                // connected
                return;
            }
            // check for sizes
            if (sizes[r1] >= sizes[r2]) {
                sizes[r1] += sizes[r2];
                parents[r2] = r1;
                parents[id2] = r1;
            }
            else {
                sizes[r2] += sizes[r1];
                parents[r1] = r2;
                parents[id1] = r2;
            }
            numIslands--;
        }
        
        private int root(int id) {
            while (id != parents[id]) {
                id = parents[id];
            }
            return id;
        }
        
        private int convert (int x, int y) {
            return x * n + y;
        }
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        if (positions == null || positions.length == 0 || positions[0].length == 0 || m <= 0 || n <= 0)
            return res;
        QUFPC qufpc = new QUFPC(m, n);
        for (int[] p : positions) {
            qufpc.addLand(p[0], p[1]);
            res.add(qufpc.numIslands);
        }
        return res;
    }
}
