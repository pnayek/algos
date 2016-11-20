package leetcode.locked;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

	/*
	 * You are given a m x n 2D grid initialized with these three possible values.

		1. -1 - A wall or an obstacle.
		2. 0 - A gate.
		3. INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
		Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
		
		For example, given the 2D grid:
		INF  -1  0  INF
		INF INF INF  -1
		INF  -1 INF  -1
		  0  -1 INF INF
		After running your function, the 2D grid should be:
		  3  -1   0   1
		  2   2   1  -1
		  1  -1   2  -1
		  0  -1   3   4
	 *
	 * #286, M
	 * Google, Facebook
	 */
	
	// 18ms
	public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, i, j);
                }
            }
        }
    }
    
    private void bfs(int[][] rooms, int i, int j) {
        int d = 0, m = rooms.length, n = rooms[0].length; 
        Queue<int[]> q = new LinkedList<int[]>();
        int[] root = {i, j};
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            d++;
            for (int s = 0; s < size; s++) {
                int[] node = q.poll();
                int x = node[0], y = node[1];
                //System.out.println("x: " + x + ", y: " + y + ", d: " + d);
                if (y + 1 < n && rooms[x][y + 1] != -1 && rooms[x][y + 1] > d) {
                    int[] right = {x, y + 1};
                    q.offer(right);
                    rooms[x][y + 1] = d;
                }
                if (y - 1 >= 0 && rooms[x][y - 1] != -1 && rooms[x][y - 1] > d) {
                    int[] left = {x, y - 1};
                    q.offer(left);
                    rooms[x][y - 1] = d;
                }
                if (x - 1 >= 0 && rooms[x - 1][y] != -1 && rooms[x - 1][y] > d) {
                    int[] up = {x - 1, y};
                    q.offer(up);
                    rooms[x - 1][y] = d;
                }
                if (x + 1 < m && rooms[x + 1][y] != -1 && rooms[x + 1][y] > d) {
                    int[] down = {x + 1, y};
                    q.offer(down);
                    rooms[x + 1][y] = d;
                }
            }
        }
    }
    
    // 26ms
    public void wallsAndGates1(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        Queue<int[]> q = new LinkedList<int[]>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    int[] ij = {i, j};
                    q.offer(ij);
                }
            }
        }
        bfs(rooms, q);
    }
    
    private void bfs(int[][] rooms, Queue<int[]> q) {
        int d = 0, m = rooms.length, n = rooms[0].length; 
        while (!q.isEmpty()) {
            int size = q.size();
            d++;
            for (int s = 0; s < size; s++) {
                int[] node = q.poll();
                int x = node[0], y = node[1];
                //System.out.println("x: " + x + ", y: " + y + ", d: " + d);
                if (y + 1 < n && rooms[x][y + 1] != -1 && rooms[x][y + 1] > d) {
                    int[] right = {x, y + 1};
                    q.offer(right);
                    rooms[x][y + 1] = d;
                }
                if (y - 1 >= 0 && rooms[x][y - 1] != -1 && rooms[x][y - 1] > d) {
                    int[] left = {x, y - 1};
                    q.offer(left);
                    rooms[x][y - 1] = d;
                }
                if (x - 1 >= 0 && rooms[x - 1][y] != -1 && rooms[x - 1][y] > d) {
                    int[] up = {x - 1, y};
                    q.offer(up);
                    rooms[x - 1][y] = d;
                }
                if (x + 1 < m && rooms[x + 1][y] != -1 && rooms[x + 1][y] > d) {
                    int[] down = {x + 1, y};
                    q.offer(down);
                    rooms[x + 1][y] = d;
                }
            }
        }
    }
}
