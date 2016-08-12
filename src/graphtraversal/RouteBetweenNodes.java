package graphtraversal;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import datastructures.GraphNode;

public class RouteBetweenNodes {

	/*
	 * CtCI 4.1
	 * Given a graph design an algorithm to find if there is a route between two nodes
	 */
	public boolean routeBetweenNodesUndirectedGraph(GraphNode n1, GraphNode n2) {
		// do a bidirectional search
		// one BFS from n1, another BFS from n2
		// if there is a common node in the two searches, then route exists
		if (n1 == null || n2 == null) return false;
		if (n1 == n2) return true;
		
		Queue<GraphNode> q1 = new LinkedList<GraphNode>();
		Queue<GraphNode> q2 = new LinkedList<GraphNode>();
		Set<GraphNode> visited1 = new HashSet<GraphNode>();
		Set<GraphNode> visited2 = new HashSet<GraphNode>();
		
		q1.offer(n1); q2.offer(n2);
		visited1.add(n1); visited2.add(n2);
		
		while (!q1.isEmpty() && !q2.isEmpty()) {
			GraphNode node1 = q1.poll();
			if (visited2.contains(node1)) return true;
			for (GraphNode child: node1.children) {
				if (visited2.contains(child)) return true;
				if (!visited1.contains(child)) {
					visited1.add(child);
					q1.offer(child);
				}
			}
			GraphNode node2 = q2.poll();
			if (visited1.contains(node2)) return true;
			for (GraphNode child: node2.children) {
				if (visited1.contains(child)) return true;
				if (!visited2.contains(child)) {
					visited2.add(child);
					q2.offer(child);
				}
			}
		}
		return false;
	}
	
	public boolean routeBetweenNodesDirectedGraph(GraphNode src, GraphNode dest) {
		// do a BFS
		if (src == null || dest == null) return false;
		if (src == dest) return true;
		
		Queue<GraphNode> q = new LinkedList<GraphNode>();
		Set<GraphNode> visited = new HashSet<GraphNode>();
		
		q.offer(src);
		visited.add(src);
		
		while (!q.isEmpty()) {
			GraphNode node = q.poll();
			if (node == dest) return true;
			for (GraphNode child: node.children) {
				if (visited.contains(child)) return true;
				if (!visited.contains(child)) {
					visited.add(child);
					q.offer(child);
				}
			}
		}
		return false;
	}
}
