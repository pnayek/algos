package graphtraversal;

import java.util.LinkedList;
import java.util.Queue;

import datastructures.GraphNode;

public class GraphTraversal {

	public static void depthFirstSearchRecursive(GraphNode root) {
		if (root == null) return;
		System.out.println(root.val);
		root.visited = true;
		for (GraphNode child: root.children) {
			if (!child.visited) {
				depthFirstSearchRecursive(child);
			}
		}
	}
	
	public static void breadthFirstSearch(GraphNode root) {
		if (root == null) return;
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		root.visited = true;
		queue.offer(root);
		while (!queue.isEmpty()) {
			GraphNode node = queue.poll();
			System.out.println(root.val);
			for (GraphNode child: node.children) {
				if (!child.visited) {
					child.visited = true;
					queue.offer(child);
				}
			}
		}
	}
	
}
