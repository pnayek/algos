package topologicalsort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleII {
	/*
	 * There are a total of n courses you have to take, labeled from 0 to n - 1.
	 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
	 * which is expressed as a pair: [0,1]
	 * 
	 * Given the total number of courses and a list of prerequisite pairs,
	 * return the ordering of courses you should take to finish all courses.
	 * 
	 * There may be multiple correct orders, you just need to return one of them.
	 * If it is impossible to finish all courses, return an empty array.
	 * 
	 * For example:
	 * 
	 * 2, [[1,0]]
	 * There are a total of 2 courses to take. To take course 1 you should have finished course 0.
	 * So the correct course order is [0,1]
	 * 
	 * 4, [[1,0],[2,0],[3,1],[3,2]]
	 * There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
	 * Both courses 1 and 2 should be taken after you finished course 0.
	 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
	 * 
	 * Note: The input prerequisites is a graph represented by a list of edges, not adjacency matrices
	 * 
	 * Leetcode #210, Medium
	 * Facebook, Zenefits
	 * 
	 */
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        List<Set<Integer>> parents = new ArrayList<Set<Integer>>(numCourses);
        List<Set<Integer>> children = new ArrayList<Set<Integer>>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            parents.add(new HashSet<Integer>());
            children.add(new HashSet<Integer>());
        }
        for (int[] edge: prerequisites) {
            int u = edge[1];
            int v = edge[0];
            // u --> v is an edge indicating u must be done before v
            parents.get(v).add(u);
            children.get(u).add(v);
        }
        // do a topological sort with return array mimicking queue 
        // 1. find all the nodes with no incoming edges
        // these courses can be taken in the beginning
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (parents.get(i).isEmpty()) {
                order[count++] = i;
            }
        }
        int i = 0;
        while (i < count) {
            int u = order[i++];
            // remove all outgoing edges of the form u --> v
            Set<Integer> childrenOfU = children.get(u);
            for (int v : childrenOfU) {
                Set<Integer> parentsOfV = parents.get(v);
                parentsOfV.remove(u);
                if (parentsOfV.isEmpty()) {
                    // no incoming edge into v, can be done next
                    order[count++] = v;
                }
            }
            childrenOfU.clear();
        }
        return count == numCourses ? order : new int[0];
    }
	
	public int[] findOrderQueue(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        List<Set<Integer>> parents = new ArrayList<Set<Integer>>(numCourses);
        List<Set<Integer>> children = new ArrayList<Set<Integer>>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            parents.add(new HashSet<Integer>());
            children.add(new HashSet<Integer>());
        }
        for (int[] edge: prerequisites) {
            int u = edge[1];
            int v = edge[0];
            // u --> v is an edge indicating u must be done before v
            parents.get(v).add(u);
            children.get(u).add(v);
        }
        // do a topological sort
        // 1. find all the nodes with no incoming edges
        // these courses can be taken in the beginning
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (parents.get(i).isEmpty()) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order[count++] = u;
            // remove all outgoing edges of the form u --> v
            Set<Integer> childrenOfU = children.get(u);
            for (int v : childrenOfU) {
                Set<Integer> parentsOfV = parents.get(v);
                parentsOfV.remove(u);
                if (parentsOfV.isEmpty()) {
                    // no incoming edge into v, can be done next
                    queue.offer(v);
                }
            }
            childrenOfU.clear();
        }
        return count == numCourses ? order : new int[0];
    }
}
