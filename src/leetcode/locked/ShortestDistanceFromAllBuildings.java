package leetcode.locked;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestDistanceFromAllBuildings {

	/*
	 * You want to build a house on an empty land which reaches all buildings
	 * in the shortest amount of distance. You can only move up, down, left and right.
	 * You are given a 2D grid of values 0, 1 or 2, where:

		Each 0 marks an empty land which you can pass by freely.
		Each 1 marks a building which you cannot pass through.
		Each 2 marks an obstacle which you cannot pass through.
		For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
		
		1 - 0 - 2 - 0 - 1
		|   |   |   |   |
		0 - 0 - 0 - 0 - 0
		|   |   |   |   |
		0 - 0 - 1 - 0 - 0
		The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
		
		Note:
		There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
	 *
	 * #317, H
	 * Google, Zenefits
	 */
	
	// 19ms
	public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int[][][] distance = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    distance[i][j][1] = -1;
                }
            }
        }
        int numBldgs = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, distance, i, j, numBldgs);
                    numBldgs++;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int[][] row : distance) {
            for (int[] d : row) {
                //System.out.print(d + " ");
                if (d[0] == numBldgs && d[1] > 0 && d[1] < min) {
                    min = d[1];
                }
            }
            //System.out.println();
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private void bfs(int[][] grid, int[][][] distance, int i, int j, int numBldgs) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        Set<Integer> seen = new HashSet<Integer>();
        queue.offer(new int[]{i, j});
        seen.add(i * n + j);
        int l = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int k = 0; k < sz; k++) {
                int[] node = queue.poll();
                int x = node[0], y = node[1];
                // right
                int neighbor = x * n + y + 1;
                if (y + 1 < n && grid[x][y + 1] == 0 && distance[x][y + 1][0] == numBldgs && !seen.contains(neighbor)) {
                    distance[x][y + 1][0]++;
                    distance[x][y + 1][1] += l;
                    queue.offer(new int[]{x, y + 1});
                    seen.add(neighbor);
                }
                // left
                neighbor = x * n + y - 1;
                if (y - 1 >= 0 && grid[x][y - 1] == 0 && distance[x][y - 1][0] == numBldgs && !seen.contains(neighbor)) {
                    distance[x][y - 1][0]++;
                    distance[x][y - 1][1] += l;
                    queue.offer(new int[]{x, y - 1});
                    seen.add(neighbor);
                }
                // up
                neighbor = (x - 1) * n + y;
                if (x - 1 >= 0 && grid[x - 1][y] == 0 && distance[x - 1][y][0] == numBldgs && !seen.contains(neighbor)) {
                    distance[x - 1][y][0]++;
                    distance[x - 1][y][1] += l;
                    queue.offer(new int[]{x - 1, y});
                    seen.add(neighbor);
                }
                // down
                neighbor = (x + 1) * n + y;
                if (x + 1 < m && grid[x + 1][y] == 0 && distance[x + 1][y][0] == numBldgs && !seen.contains(neighbor)) {
                    distance[x + 1][y][0]++;
                    distance[x + 1][y][1] += l;
                    queue.offer(new int[]{x + 1, y});
                    seen.add(neighbor);
                }
            }
            l++;
        }
    }
    
    // 241ms
	public int shortestDistance1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int[][][] distance = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    distance[i][j][1] = -1;
                }
            }
        }
        int numBldgs = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    numBldgs++;
                    bfs(grid, distance, i, j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int[][] row : distance) {
            for (int[] d : row) {
                //System.out.print(d + " ");
                if (d[0] == numBldgs && d[1] > 0 && d[1] < min) {
                    min = d[1];
                }
            }
            //System.out.println();
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private void bfs(int[][] grid, int[][][] distance, int i, int j) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        Set<Integer> seen = new HashSet<Integer>();
        queue.offer(new int[]{i, j});
        seen.add(i * n + j);
        int l = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int k = 0; k < sz; k++) {
                int[] node = queue.poll();
                int x = node[0], y = node[1];
                // right
                int neighbor = x * n + y + 1;
                if (y + 1 < n && grid[x][y + 1] == 0 && !seen.contains(neighbor)) {
                    distance[x][y + 1][0]++;
                    distance[x][y + 1][1] += l;
                    queue.offer(new int[]{x, y + 1});
                    seen.add(neighbor);
                }
                // left
                neighbor = x * n + y - 1;
                if (y - 1 >= 0 && grid[x][y - 1] == 0 && !seen.contains(neighbor)) {
                    distance[x][y - 1][0]++;
                    distance[x][y - 1][1] += l;
                    queue.offer(new int[]{x, y - 1});
                    seen.add(neighbor);
                }
                // up
                neighbor = (x - 1) * n + y;
                if (x - 1 >= 0 && grid[x - 1][y] == 0 && !seen.contains(neighbor)) {
                    distance[x - 1][y][0]++;
                    distance[x - 1][y][1] += l;
                    queue.offer(new int[]{x - 1, y});
                    seen.add(neighbor);
                }
                // down
                neighbor = (x + 1) * n + y;
                if (x + 1 < m && grid[x + 1][y] == 0 && !seen.contains(neighbor)) {
                    distance[x + 1][y][0]++;
                    distance[x + 1][y][1] += l;
                    queue.offer(new int[]{x + 1, y});
                    seen.add(neighbor);
                }
            }
            l++;
        }
    }
}
