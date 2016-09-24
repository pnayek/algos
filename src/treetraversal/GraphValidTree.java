package treetraversal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphValidTree {

	/*
	 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
	 * write a function to check whether these edges make up a valid tree.
	 * For example: Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
	 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false
	 * 
	 * Leetcode #261, Medium
	 * Facebook, Google, Zenefits
	 */
	
	// BFS - O(n), O(n)
	public boolean validTree(int n, int[][] edges) {
        // a valid tree must have n - 1 edges
        int m = edges.length;
        if (m != n - 1) return false;
        // pick any node as root say 0
        // no cycle should exist
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>(n);
        for (int i = 0; i < n; i++)
            graph.add(new HashSet<Integer>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] seen = new boolean[n];
        int[] queue = new int[n];
        queue[0] = 0;
        seen[0] = true;
        int count = 1;
        int i = 0;
        while (i < count) {
            int u = queue[i++];
            for (int v: graph.get(u)) {
                if (seen[v]) {
                    return false;
                }
                seen[v] = true;
                queue[count++] = v;
                graph.get(v).remove(u);
            }
        }
        return count == n;
    }
}
