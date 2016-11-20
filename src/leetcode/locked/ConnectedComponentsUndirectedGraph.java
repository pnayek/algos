package leetcode.locked;

public class ConnectedComponentsUndirectedGraph {

	/*
	 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
	 * write a function to find the number of connected components in an undirected graph.

		Example 1:
		     0          3
		     |          |
		     1 --- 2    4
		Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

		Example 2:
		     0           4
		     |           |
		     1 --- 2 --- 3
		Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

		Note:
		You can assume that no duplicate edges will appear in edges.
		Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
	 *
	 * #323, M
	 * Google, Twitter
	 */

	public class Wqufpc {

		int[] parents;
		int[] sizes;
		int count;

		public Wqufpc(int n) {
			parents = new int[n];
			sizes = new int[n];
			for (int i = 0; i < n; i++) {
				parents[i] = i;
				sizes[i] = 1;
			}
			count = n;
		}

		public int root(int u) {
			while (parents[u] != u) {
				u = parents[u];
			}
			return u;
		}

		public void union(int u, int v) {
			int rootu = root(u);
			int rootv = root(v);
			// path compression
			parents[u] = rootu;
			parents[v] = rootv;
			if (rootu == rootv) {
				return;
			}
			int szu = sizes[rootu];
			int szv = sizes[rootv];
			if (szu <= szv) {
				// make rootv the child of rootu
				parents[rootv] = rootu;
				sizes[rootu] += sizes[rootv];
			}
			else {
				// make rootu the child of rootv
				parents[rootu] = rootv;
				sizes[rootv] += sizes[rootu];
			}
			count--;
		}
	}

	public int countComponents(int n, int[][] edges) {
		// weighted quick union find
		Wqufpc w = new Wqufpc(n);
		for (int[] edge : edges) {
			w.union(edge[0], edge[1]);
		}
		return w.count;
	}
}
