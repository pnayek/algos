package leetcode.locked;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GraphValidTree {

	/*
	 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
	 * write a function to check whether these edges make up a valid tree.
	 * For example:
	 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
	 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
	 * Hint:
	 * 1. Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
	 * 2. According to the definition of tree on Wikipedia: Òa tree is an undirected graph in which any two
	 * vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.Ó
	 * 
	 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected,
	 * [0, 1] is the same as [1, 0] and thus will not appear together in edges.
	 * 
	 * #261, M
	 * Google, Facebook, Zenefits
	 */
	
	// 5ms
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
	
	// 10ms
	public boolean validTree2(int n, int[][] edges) {
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
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        seen[0] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v: graph.get(u)) {
                if (seen[v]) {
                    return false;
                }
                seen[v] = true;
                count++;
                queue.offer(v);
                graph.get(v).remove(u);
            }
        }
        return count == n;
    }
	
	// 10ms
	public boolean validTree1(int n, int[][] edges) {
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
        Set<Integer> seen = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        seen.add(0);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v: graph.get(u)) {
                if (seen.contains(v)) {
                    return false;
                }
                seen.add(v);
                queue.offer(v);
                graph.get(v).remove(u);
            }
        }
        return seen.size() == n;
    }
}
