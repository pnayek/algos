package leetcode.locked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint {

	/*
	 * A group of two or more people wants to meet and minimize the total travel distance.
	 * You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group.
	 * The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

		For example, given three people living at (0,0), (0,4), and (2,2):
		
		1 - 0 - 0 - 0 - 1
		|   |   |   |   |
		0 - 0 - 0 - 0 - 0
		|   |   |   |   |
		0 - 0 - 1 - 0 - 0
		The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
		
		Hint:
		
		Try to solve it in one dimension first. How can this solution apply to the two dimension case?
	 *
	 * #296, H
	 * Twitter
	 */
	
	// 15ms
	public int minTotalDistance(int[][] grid) {
        List<Integer> xValues = new ArrayList<Integer>();
        List<Integer> yValues = new ArrayList<Integer>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    xValues.add(i);
                    yValues.add(j);
                }
            }
        }
        // x is already sorted
        int dx = distance(xValues);
        Collections.sort(yValues);
        int dy = distance(yValues);
        return dx + dy;
    }
    
    private int distance(List<Integer> values) {
        int sum = 0, lo = 0, hi = values.size() - 1;
        while (lo < hi) {
            sum += values.get(hi) - values.get(lo);
            lo++; hi--;
        }
        return sum;
    }
    
	// 20ms
	public int minTotalDistance2(int[][] grid) {
        List<Integer> xValues = new ArrayList<Integer>();
        List<Integer> yValues = new ArrayList<Integer>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    xValues.add(i);
                    yValues.add(j);
                }
            }
        }
        // x is already sorted
        int x = xValues.get(xValues.size() / 2);
        int y = median(yValues);
        int dx = distance(xValues, x);
        int dy = distance(yValues, y);
        return dx + dy;
    }
    
	// 17ms
	public int minTotalDistance1(int[][] grid) {
        List<Integer> xValues = new ArrayList<Integer>();
        List<Integer> yValues = new ArrayList<Integer>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    xValues.add(i);
                    yValues.add(j);
                }
            }
        }
        int x = median(xValues);
        int y = median(yValues);
        int dx = distance(xValues, x);
        int dy = distance(yValues, y);
        return dx + dy;
    }
    
    private int median(List<Integer> values) {
        Collections.sort(values);
        int pos = values.size() / 2;
        return values.get(pos);
    }
    
    private int distance(List<Integer> values, int v) {
        int sum = 0;
        for (int x : values) {
            sum += v < x ? x - v : v - x;
        }
        return sum;
    }
}
