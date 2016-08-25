package topologicalsort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {

	private boolean hasNoIncomingEdge(List<Set<Integer>> parents, int node) {
        return parents.get(node).size() == 0;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> children = new ArrayList<Set<Integer>>(numCourses);
        List<Set<Integer>> parents = new ArrayList<Set<Integer>>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            children.add(new HashSet<Integer>());
            parents.add(new HashSet<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            // u -> v edge in the graph means u must be done before v
            children.get(u).add(v);
            parents.get(v).add(u);
        }
        // if we can topologically sort the graph
        // then there is an order among the courses
        // this is possible if the graph is a DAG
        
        // 1. push all nodes with no incoming edges into a queue
        // these nodes represent courses that have no prereqs
        Queue<Integer> order = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (hasNoIncomingEdge(parents, i)) {
                order.offer(i);
            }
        }
        
        // 2. while the queue is not empty
        // poll a node, remove all its outgoing edges from its neighbors
        // now add those neighbors that have no incoming edges
        // conceptually, we are taking the course done out of the queue
        // now all those courses which had the done course as prereq
        // can now be done provided they have no other prereqs
        // keep a count of how many courses are getting done
        int count = 0;
        while (!order.isEmpty()) {
            int u = order.poll();
            count++;
            for (int v: children.get(u)) {
                parents.get(v).remove(u);
                if (hasNoIncomingEdge(parents, v)) {
                    order.offer(v);
                }
            }
        }
        
        // 3. for a valid topological order, count must match numCourses
        return count == numCourses;
        
    }
}
